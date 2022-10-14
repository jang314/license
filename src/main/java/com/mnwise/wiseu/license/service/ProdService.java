package com.mnwise.wiseu.license.service;

import com.mnwise.wiseu.license.domain.Product;
import com.mnwise.wiseu.license.dto.ProductDTO;
import com.mnwise.wiseu.license.repository.ProdRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProdService {
    private final ProdRepository prodRepository;


    @Transactional
    public void save(ProductDTO productDTO) {
//        Cust cust = custRepository.findOne(productDTO.getCust());
//        if(cust.getId().equals(productDTO.getCust())) {
//            CustProd custProd = CustProd.createCustProd(cust);
//            Product product = Product.createProduct(custProd)
//                    .builder()
//                    .id(productDTO.getName() + productDTO.getVersion())
//                    .version(productDTO.getVersion())
//                    .build();
//            prodRepository.save(product);
//        } else {
//            throw new IllegalStateException("고객사가 존재하지 않습니다.");
//        }
//    }
        prodRepository.save(Product.builder()
                    .id(productDTO.getName() + productDTO.getVersion())
                    .version(productDTO.getVersion())
                    .product(productDTO.getName())
                    .build());
    }
}
