package com.mnwise.wiseu.license.service;

import com.mnwise.wiseu.license.domain.CustType;
import com.mnwise.wiseu.license.dto.CustTypeDTO;
import com.mnwise.wiseu.license.repository.CustTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class CustTypeService {
    private final CustTypeRepository custTypeRepository;

    @Transactional
    public Long save(CustType custType) {
        return custTypeRepository.save(custType).getId();
    }

    @Transactional
    public boolean existsByName(String name) {
        return custTypeRepository.existsByName(name);
    }


    public CustTypeDTO findOne(Long id) {
        return null;
    }
}
