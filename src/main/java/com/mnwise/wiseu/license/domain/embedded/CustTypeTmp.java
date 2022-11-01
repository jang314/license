package com.mnwise.wiseu.license.domain.embedded;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "XCUST_TYPE_INFO_TMP")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustTypeTmp extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_type_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "custType", cascade = CascadeType.ALL)
    private List<CustTmp> custs = new ArrayList<>();
}
