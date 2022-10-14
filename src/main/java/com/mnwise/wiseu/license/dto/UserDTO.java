package com.mnwise.wiseu.license.dto;

import com.mnwise.wiseu.license.domain.Auth;
import lombok.Data;
import lombok.Getter;

@Data
public class UserDTO {
    private String email;
    private String password;
    private String name;
    private String custId;
    private Auth auth;

}
