package com.mnwise.wiseu.license.service;

import com.mnwise.wiseu.license.dto.CustTypeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustTypeServiceTest {

    @Test
    public void test() {
        CustTypeDTO custTypeDTO = new CustTypeDTO();
        custTypeDTO.setName("금융/제조");
        System.out.println("test");
    }

}