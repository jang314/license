package com.mnwise.wiseu.license.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="XPROD_INFO")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Product extends BaseEntity{
    @Id
    @Column(name = "prod_id")
    private String id;

    private String product;
    private String version;

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustProd> custProds = new ArrayList<>();

    public void addCustProd(CustProd custProd) {
        custProds.add(custProd);
        custProd = CustProd.builder().product(this).build();
    }

    public static Product createProduct (CustProd... custProds) {
        Product product = Product.builder().build();
        for(CustProd custProd : custProds) {
            product.addCustProd(custProd);
        }
        product.setInsDate(LocalDateTime.now());
        product.setInsUser("jang314@mnwise.com");
        return product;
    }

}
