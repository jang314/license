package com.mnwise.wiseu.license.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "XCUST_INFO")
@Data
public class Cust {
    @Id
    @GeneratedValue
    @Column(name = "cust_id")
    private String id;
    private String name;

    private String Address;
    private String memo;

    @OneToMany(mappedBy = "cust")
    private List<CustProd> custProds = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cust_type_id")
    private CustType custType;

}
