package com.mnwise.wiseu.license.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "XCUST_INFO")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Cust extends BaseEntity{
    @Id
//    @GeneratedValue
    @Column(name = "cust_id")
    private String id;
    private String name;

    @Embedded
    private Address address;
    private String memo;

    @OneToMany(mappedBy = "cust")
    private List<CustProd> custProds = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cust_type_id")
    private CustType custType;

    @OneToMany(mappedBy = "cust")
    private List<Member> members = new ArrayList<>();

    public void setCustType(CustType custType) {
        this.custType = custType;
        custType.getCusts().add(this);
    }



}
