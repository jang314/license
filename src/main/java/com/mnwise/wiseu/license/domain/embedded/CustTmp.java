package com.mnwise.wiseu.license.domain.embedded;

import com.mnwise.wiseu.license.domain.Address;
import com.mnwise.wiseu.license.domain.id.CustId;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "XCUST_INFO_TMP")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString(exclude = "licenses")
public class CustTmp extends BaseEntity {
    @EmbeddedId
    private CustId custId;

    @MapsId("custTypeId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cust_type_id")
    private CustTypeTmp custType;

    @Embedded
    private Address address;
    private String memo;


//    @OneToMany(mappedBy = "cust")
//    private List<License> licenses = new ArrayList<>();

//    @OneToMany(mappedBy = "cust")
//    private List<User> users = new ArrayList<>();

//    public void addLicense(License license) {
//        licenses.add(license);
//        license.setCust(this);
//    }

//    public void addUser(User user) {
//        users.add(user);
//        user.setCust(this);
//    }


}
