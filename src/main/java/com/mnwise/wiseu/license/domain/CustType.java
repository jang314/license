package com.mnwise.wiseu.license.domain;

import lombok.Data;
import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "XCUST_TYPE_INFO")
@Data
public class CustType {
    @Id
    @GeneratedValue
    @Column(name = "cust_type_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "custType")
    private List<Cust> custs = new ArrayList<>();

}
