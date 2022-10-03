package com.mnwise.wiseu.license.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "XCUST_PROD_INFO")
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustProd {
    @Id @GeneratedValue
    @Column(name = "cust_prod_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cust_id")
    private Cust cust;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prod_id")
    private Product product;

    @OneToMany(mappedBy = "custProd")
    private List<Server> serverList = new ArrayList<>();

    public void setCustProd(CustProd custProd) {
        this.product = custProd.product;
        this.cust = custProd.cust;
        custProd.cust.getCustProds().add(this);
        custProd.product.getCustProds().add(this);
    }

    public static CustProd createCustProd(Cust cust) {
        CustProd custProd = CustProd.builder().cust(cust).build();
        return custProd;
    }

}
