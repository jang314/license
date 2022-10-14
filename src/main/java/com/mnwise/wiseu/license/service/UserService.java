package com.mnwise.wiseu.license.service;

import com.mnwise.wiseu.license.domain.Cust;
import com.mnwise.wiseu.license.domain.User;
import com.mnwise.wiseu.license.dto.UserDTO;
import com.mnwise.wiseu.license.repository.CustRepository;
import com.mnwise.wiseu.license.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
private final CustRepository custRepository;
    public User save(UserDTO userDTO) {
        Cust cust = custRepository.findById(userDTO.getCustId()).get();
        User user = new User(userDTO);
        user.setCust(cust);
        custRepository.save(cust);
        return userRepository.findById(userDTO.getEmail()).get();
    }
}
