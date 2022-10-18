package com.mnwise.wiseu.license.validator;

import com.mnwise.wiseu.license.dto.CustDTO;
import com.mnwise.wiseu.license.dto.ProductDTO;
import com.mnwise.wiseu.license.service.CustService;
import com.mnwise.wiseu.license.service.CustTypeService;
import com.mnwise.wiseu.license.service.ProdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class ProductValidator implements Validator {
    private final ProdService prodService;
    private final CustTypeService custTypeService;

    @Override
    public boolean supports(Class<?> clazz) {
        return ProductDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDTO productDTO = (ProductDTO) target;
        if(prodService.existsByNameAndVersion(productDTO.getName(), productDTO.getVersion())) {
            errors.rejectValue("name", Status.BAD_REQUEST.name(),"이미 존재하는 버전의 제품입니다.");
        }
    }
}
