package com.mnwise.wiseu.license.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "XCUST_PROD_INFO")
@Data
public class CustProd {
    @Id @GeneratedValue
    @Column(name = "cust_prod_id")
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cust_id")
    private Cust cust;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prod_id")
    private Product product;

    @OneToMany(mappedBy = "custProd")
    private List<Server> serverList;

}
