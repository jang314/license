package com.mnwise.wiseu.license.domain;

import javax.persistence.*;

@Entity
public class Member  extends BaseEntity {
    @Id @GeneratedValue
    private String email;
    private String name;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Cust cust;

    @Enumerated(EnumType.STRING)
    private Auth auth;


}
