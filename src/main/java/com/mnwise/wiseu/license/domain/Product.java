package com.mnwise.wiseu.license.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="XPROD_INFO")
@Data
public class Product {
    @Id @GeneratedValue
    @Column(name = "prod_id")
    private String id;

    private String name;

    @OneToMany(mappedBy = "product")
    private List<CustProd> custProds = new ArrayList<>();
}
