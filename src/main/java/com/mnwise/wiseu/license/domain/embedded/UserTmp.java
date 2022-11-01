package com.mnwise.wiseu.license.domain.embedded;

import com.mnwise.wiseu.license.domain.code.Auth;
import com.mnwise.wiseu.license.dto.UserDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "XUSER_INFO_TMP")
@Getter
@NoArgsConstructor
public class UserTmp extends BaseEntity {
    @Id
    private String email;
    private String name;
    private String password;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "cust_id")
//    private Cust cust;

    @Enumerated(EnumType.STRING)
    private Auth auth;
//
//    @ManyToMany
//    @JoinTable(name = "USER_PRODUCT",
//            joinColumns = @JoinColumn(name = "email"),
//            inverseJoinColumns = @JoinColumn(name = "product_id"))
//    private List<Product> products = new ArrayList<Product>();

    public UserTmp(UserDTO userDTO) {
        this.email = userDTO.getEmail();
        this.name = userDTO.getName();
        this.password = userDTO.getPassword();
        this.auth = userDTO.getAuth();

    }

//    public void setCust(Cust cust) {
//        this.cust = cust;
//        cust.getUsers().add(this);
//    }
}
