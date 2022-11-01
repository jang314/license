package com.mnwise.wiseu.license.dto;

import com.mnwise.wiseu.license.domain.code.Auth;
import lombok.Data;

@Data
public class UserDTO {
    private String email;
    private String password;
    private String name;
    private Long custId;
    private Auth auth;

}
