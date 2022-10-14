package com.mnwise.wiseu.license.service;

import com.mnwise.wiseu.license.domain.Cust;
import com.mnwise.wiseu.license.domain.License;
import com.mnwise.wiseu.license.domain.Product;
import com.mnwise.wiseu.license.domain.Server;
import com.mnwise.wiseu.license.dto.LicenseDTO;
import com.mnwise.wiseu.license.dto.ServerDTO;
import com.mnwise.wiseu.license.repository.CustRepository;
import com.mnwise.wiseu.license.repository.LicenseRepository;
import com.mnwise.wiseu.license.repository.ProdRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class LicenseService {
    private final LicenseRepository licenseRepository;
    private final CustRepository custRepository;
    private final ProdRepository prodRepository;

    @Transactional
    public License save(LicenseDTO licenseDto) {
        try{
            Cust cust = custRepository.findById(licenseDto.getCustId()).get();
            Product product = prodRepository.findById(licenseDto.getProduct()).get();
            License license = new License(licenseDto);
            license.makeLicenseKey(cust, product);
            custRepository.save(cust);
            prodRepository.save(product);
            return license;
        } catch(Exception e) {
            e.printStackTrace();
            log.error(e.toString());
            return null;
        }
    }
}
