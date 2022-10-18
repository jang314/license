package com.mnwise.wiseu.license.service;

import com.mnwise.wiseu.license.domain.CustType;
import com.mnwise.wiseu.license.domain.QCustType;
import com.mnwise.wiseu.license.dto.CustTypeDTO;
import com.mnwise.wiseu.license.dto.QCustTypeDTO;
import com.mnwise.wiseu.license.repository.CustTypeRepository;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.mnwise.wiseu.license.domain.QCustType.*;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class CustTypeService {
    private final CustTypeRepository custTypeRepository;
    private final JPAQueryFactory queryFactory;

    @Transactional
    public Long save(CustType custType) {
        return custTypeRepository.save(custType).getId();
    }

    @Transactional
    public boolean existsByName(String name) {
        return custTypeRepository.existsByName(name);
    }


    public Long findById(Long id) {
        return Optional.ofNullable(custTypeRepository.findById(id).get().getId())
                .orElse(0L);
    }

    public Page<CustTypeDTO> findList(Pageable pageable, String name) {
        List<CustTypeDTO> contents = queryFactory.select(new QCustTypeDTO(custType.id.as("custTypeId"), custType.name))
                .from(custType)
                .where(nameContents(name))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory.select(custType.count()).from(custType).where(nameContents(name));
//        Long totalCount = queryFactory.select(custType.count()).from(custType).where(nameContents(name)).fetchOne();



        return PageableExecutionUtils.getPage(contents, pageable, countQuery::fetchOne);
    }

    private BooleanExpression nameContents(String name)  {
        return StringUtils.hasText(name) ? custType.name.contains(name) : null;
    }
}
