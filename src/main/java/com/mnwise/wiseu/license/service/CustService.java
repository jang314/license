package com.mnwise.wiseu.license.service;

import com.mnwise.wiseu.license.domain.Cust;
import com.mnwise.wiseu.license.dto.*;
import com.mnwise.wiseu.license.dto.condition.CustSearchCond;
import com.mnwise.wiseu.license.dto.query.CustQueryDTO;
import com.mnwise.wiseu.license.dto.query.QCustQueryDTO;
import com.mnwise.wiseu.license.repository.CustRepository;
import com.mnwise.wiseu.license.repository.CustTypeRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.mnwise.wiseu.license.domain.QCust.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustService {
    private final CustRepository custRepository;
    private final CustTypeRepository custTypeRepository;
    private final JPAQueryFactory queryFactory;


    @Transactional
    public String save(CustDTO custDTO) {
        Cust cust = Cust.builder()
                .custType(custTypeRepository.findById(custDTO.getCustType()).get())
                .id(String.format("%05d", custDTO.getCustType())).name(custDTO.getName()).build();
        return custRepository.save(cust).getId();
    }

    public boolean existsByNameAndCustType(String name, Long custType) {
        return custRepository.existsByNameAndCustTypeId(name, custType);
    }


    // join : fetchJoin, Creteria, jpql, QueryDsl
//    public Page<CustMixDTO> findList(Pageable pageable, CustSearchCondition condition) {
//        List<CustMixDTO> content = queryFactory.select(new QCustMixDTO(custType.id.as("custTypeId"),
//                        custType.name.as("custTypeNm"),
//                        cust.id.as("custId"),
//                        cust.name.as("custNm")))
//                .from(cust)
//                .innerJoin(cust.custType)
//                .where(searchCustType(condition.getCustType()), searchCustNm(condition.getCustName()))
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .fetch();
//
//        JPAQuery<Cust> countQuery = queryFactory
//                .select(cust)
//                .from(cust);
//
//        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchCount);
//    }

    public Page<CustQueryDTO> findList(Pageable pageable, CustSearchCond condition) {
        List<CustQueryDTO> content = queryFactory.select(new QCustQueryDTO(cust.id.as("custId"),
                        cust.name, cust.custType.id.as("custTypeId"), cust.custType.name))
                .from(cust)
                .innerJoin(cust.custType)
                .where(searchCustType(condition.getCustType()), searchCustNm(condition.getCustName()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Cust> countQuery = queryFactory.select(cust)
                .from(cust)
                .where(searchCustType(condition.getCustType()), searchCustNm(condition.getCustName()));

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchCount);
    }


    private BooleanExpression searchCustType(Long custTypeId) {
         return custTypeId == null ? null : cust.custType.id.eq(custTypeId);
    }

    private BooleanExpression searchCustNm(String custNm) {
        return StringUtils.hasText(custNm) ?  cust.name.contains(custNm) : null;
    }

    public boolean existsById(String custId) {
        return custRepository.existsById(custId);
    }
}
