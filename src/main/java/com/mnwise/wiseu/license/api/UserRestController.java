package com.mnwise.wiseu.license.api;

import com.mnwise.wiseu.license.dto.UserDTO;
import com.mnwise.wiseu.license.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class UserRestController {
    private final UserService userService;

    @PostMapping(value = "/api/user")
    public UserDTO save(@Valid @RequestBody UserDTO userDTO) {
        userService.save(userDTO);
        return new UserDTO();
    }
}
