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
@ToString(exclude = "licenses")
public class Cust extends BaseEntity{
    @Id
    @Column(name = "cust_id")
    private String id;
    private String name;

    @Embedded
    private Address address;
    private String memo;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cust_type_id")
    private CustType custType;

    @OneToMany(mappedBy = "cust", cascade = CascadeType.ALL)
    private List<License> licenses = new ArrayList<>();

    @OneToMany(mappedBy = "cust", cascade = CascadeType.ALL)
    private List<User> users = new ArrayList<>();

    public void addLicense(License license) {
        licenses.add(license);
        license.setCust(this);
    }

    public void addUser(User user) {
        users.add(user);
        user.setCust(this);
    }
}
