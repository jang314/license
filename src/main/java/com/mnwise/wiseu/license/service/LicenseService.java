package com.mnwise.wiseu.license.service;

import com.mnwise.wiseu.license.domain.*;
import com.mnwise.wiseu.license.dto.LicenseDTO;
import com.mnwise.wiseu.license.dto.condition.LicenseSearchCond;
import com.mnwise.wiseu.license.dto.query.LicenseQueryDTO;
import com.mnwise.wiseu.license.dto.query.QLicenseQueryDTO;
import com.mnwise.wiseu.license.repository.CustRepository;
import com.mnwise.wiseu.license.repository.LicenseRepository;
import com.mnwise.wiseu.license.repository.ProdRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import static com.mnwise.wiseu.license.domain.QCust.*;
import static com.mnwise.wiseu.license.domain.QCustType.*;
import static com.mnwise.wiseu.license.domain.QLicense.license;
import static com.mnwise.wiseu.license.domain.QProduct.*;
import static org.springframework.util.StringUtils.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class LicenseService {
    private final LicenseRepository licenseRepository;
    private final CustRepository custRepository;
    private final ProdRepository prodRepository;
    private final JPAQueryFactory queryFactory;

    @Transactional
    public String save(LicenseDTO licenseDto) {
        Cust cust = custRepository.findById(licenseDto.getCustId()).get();
        Product product = prodRepository.findById(licenseDto.getProduct()).get();
        License license = new License(licenseDto);
        license.makeLicenseKey(cust, product);
        custRepository.save(cust);
        prodRepository.save(product);
        return license.getId();
    }

    public Page<LicenseQueryDTO> findList(Pageable pageable, LicenseSearchCond condition) {
        List<LicenseQueryDTO> content = queryFactory
                .select(new QLicenseQueryDTO(
                        license.id,
                        license.hostNm,
                        license.ip,
                        product1.product,
                        product1.version,
                        license.expiredDate,
                        cust.name.as("custNm"),
                        custType.name.as("custType")
                ))
                .from(license)
                .leftJoin(license.cust, cust)
                .leftJoin(license.product, product1)
                .leftJoin(cust.custType, custType)
                .where(containHostNm(condition.getHostNm()),
                        containsCust(condition.getCust()),
                        containsIp(condition.getIp()),
                        eqCustType(condition.getCustType()),
                        eqProduct(condition.getProduct())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory.select(license.count())
                .from(license)
                .where(containHostNm(condition.getHostNm()),
                containsCust(condition.getCust()),
                containsIp(condition.getIp()),
                eqCustType(condition.getCustType()),
                eqProduct(condition.getProduct()));
        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }

    private BooleanExpression containHostNm(String hostNm) {
        return hasText(hostNm) ? license.hostNm.contains(hostNm) : null;
    }

    private BooleanExpression containsIp(String ip) {
        return hasText(ip) ? license.ip.contains(ip) : null;
    }

    private BooleanExpression containsCust(String custNm) {
        return hasText(custNm) ? cust.name.contains(custNm) : null;
    }

    private BooleanExpression eqProduct(String product) {
        return hasText(product) ? product1.id.eq(product) : null;
    }
    private BooleanExpression eqCustType(Long type) {
        return type!=null ? custType.id.eq(type) : null;
    }

}
