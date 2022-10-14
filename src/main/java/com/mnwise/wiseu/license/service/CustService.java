package com.mnwise.wiseu.license.service;

import com.mnwise.wiseu.license.domain.Cust;
import com.mnwise.wiseu.license.domain.CustType;
import com.mnwise.wiseu.license.dto.CustDTO;
import com.mnwise.wiseu.license.repository.CustRepository;
import com.mnwise.wiseu.license.repository.CustTypeRepository;
import com.mnwise.wiseu.license.repository.ProdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustService {
    private final CustRepository custRepository;
    private final CustTypeRepository custTypeRepository;
    private final ProdRepository prodRepository;


    @Transactional
    public void save(CustDTO custDTO) {
        CustType custType = custTypeRepository.findById(custDTO.getCustType()).get();

        if(custType != null) {
            Cust cust = Cust.builder().custType(custType).id(String.format("%05d",custType.getId())).name(custDTO.getName()).build();
            custRepository.save(cust);
        } else  {
            throw new IllegalStateException("고객사 유형이 존재하지 않습니다.");
        }
    }

    @Transactional
    public void update(CustDTO custDTO) {
        Cust cust = custRepository.findById(custDTO.getCustId()).get();


    }


}
