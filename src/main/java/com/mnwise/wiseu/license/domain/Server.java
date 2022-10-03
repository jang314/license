package com.mnwise.wiseu.license.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "XSERVER_INFO")
public class Server extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "server_id")
    private Long id;
    private String name;
    private String ip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cust_prod_id")
    private CustProd custProd;

}
