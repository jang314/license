package com.mnwise.wiseu.license.domain;

import com.mnwise.wiseu.license.dto.UserDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "XUSER_INFO")
@Getter
@NoArgsConstructor
public class User extends BaseEntity {
    @Id
    private String email;
    private String name;
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cust_id")
    private Cust cust;

    @Enumerated(EnumType.STRING)
    private Auth auth;

    public User(UserDTO userDTO) {
        this.email = userDTO.getEmail();
        this.name = userDTO.getName();
        this.password = userDTO.getPassword();
        this.auth = userDTO.getAuth();

    }

    public void setCust(Cust cust) {
        this.cust = cust;
        cust.getUsers().add(this);
    }
}
