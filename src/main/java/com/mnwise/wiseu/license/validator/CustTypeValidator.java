package com.mnwise.wiseu.license.validator;

import com.mnwise.wiseu.license.dto.CustDTO;
import com.mnwise.wiseu.license.dto.CustTypeDTO;
import com.mnwise.wiseu.license.service.CustTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class CustTypeValidator implements Validator {
    private final CustTypeService custTypeService;

    @Override
    public boolean supports(Class<?> clazz) {
        return CustTypeDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustTypeDTO custTypeDTO = (CustTypeDTO) target;
        if(custTypeService.existsByName(custTypeDTO.getName())) {
            errors.rejectValue("name", Status.BAD_REQUEST.name(),"유형명은 중복될 수 없습니당.");
        }
    }
}
