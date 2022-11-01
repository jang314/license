package com.mnwise.wiseu.license.service;

import com.mnwise.wiseu.license.domain.CustType;
import com.mnwise.wiseu.license.dto.CustTypeDTO;
import com.mnwise.wiseu.license.repository.CustTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustTypeServiceTest {

    @Autowired
    CustTypeRepository custTypeRepository;

    @Test
    public void findCustType() {
    }

}