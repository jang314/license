package com.mnwise.wiseu.license.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "XCUST_TYPE_INFO")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustType extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "cust_type_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "custType")
    private List<Cust> custs = new ArrayList<>();

}
