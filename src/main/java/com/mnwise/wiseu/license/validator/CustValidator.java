package com.mnwise.wiseu.license.validator;

import com.mnwise.wiseu.license.dto.CustDTO;
import com.mnwise.wiseu.license.service.CustService;
import com.mnwise.wiseu.license.service.CustTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class CustValidator implements Validator {
    private final CustService custService;
    private final CustTypeService custTypeService;

    @Override
    public boolean supports(Class<?> clazz) {
        return CustDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustDTO custDTO = (CustDTO) target;
//        if(custTypeService.findById(custDTO.getCustType())) {
//            errors.rejectValue("name", Status.BAD_REQUEST.name(),"존재하지 않는 유형입니다, 재 선택해주세요.");
//        }

        if(custService.existsByNameAndCustType(custDTO.getName(), custDTO.getCustType())) {
            errors.rejectValue("name", Status.BAD_REQUEST.name(),"고객사 명은 중복될 수 없습니당.");
        }


    }
}
