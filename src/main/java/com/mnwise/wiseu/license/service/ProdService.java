package com.mnwise.wiseu.license.service;

import com.mnwise.wiseu.license.domain.Product;
import com.mnwise.wiseu.license.domain.QProduct;
import com.mnwise.wiseu.license.dto.ProductDTO;
import com.mnwise.wiseu.license.dto.QProductDTO;
import com.mnwise.wiseu.license.repository.ProdRepository;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
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
import org.springframework.util.StringUtils;

import java.util.List;

import static com.mnwise.wiseu.license.domain.QProduct.product1;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProdService {
    private final ProdRepository prodRepository;
    private final JPAQueryFactory queryFactory;


    @Transactional
    public String save(ProductDTO productDTO) {
        return prodRepository.save(Product.builder()
                    .id(productDTO.getName() + productDTO.getVersion())
                    .version(productDTO.getVersion())
                    .product(productDTO.getName())
                    .build()).getId();
    }

    public boolean existsByNameAndVersion(String name, String version) {
        return prodRepository.existsByProductAndVersion(name, version);
    }

    public Page<ProductDTO> findList(Pageable pageable, ProductDTO condition) {
        List<ProductDTO> content = queryFactory.select(new QProductDTO(product1.product, product1.version))
                .from(product1)
                .where(nameContents(condition.getName()), versionContents(condition.getVersion()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Product> countQuery = queryFactory.select(product1)
                .from(product1).where();

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchCount);
    }

    private BooleanExpression versionContents(String version) {
        return StringUtils.hasText(version) ? product1.version.contains(version) : null;
    }

    private BooleanExpression nameContents(String name) {
        return StringUtils.hasText(name) ? product1.product.contains(name) : null;
    }

    public boolean existsById(String product) {
        return prodRepository.existsById(product);
    }
}
