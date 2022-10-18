package com.mnwise.wiseu.license.validator;

import com.mnwise.wiseu.license.dto.LicenseDTO;
import com.mnwise.wiseu.license.service.CustService;
import com.mnwise.wiseu.license.service.LicenseService;
import com.mnwise.wiseu.license.service.ProdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class LicenseValidator implements Validator {
    private final LicenseService licenseService;
    private final CustService custService;
    private final ProdService prodService;

    @Override
    public boolean supports(Class<?> clazz) {
        return LicenseDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LicenseDTO licenseDTO = (LicenseDTO) target;
        // 선택사항 : 고객사, 제품
        if(!custService.existsById(licenseDTO.getCustId())) {
            errors.rejectValue("custId", Status.BAD_REQUEST.name(),"존재하지 않는 고객사입니다. ");
        }

        if(!prodService.existsById(licenseDTO.getProduct())) {
            errors.rejectValue("product", Status.BAD_REQUEST.name(),"존재하지 않는 고객사입니다. ");
        }
        LocalDate expiredDate = LocalDate.parse(licenseDTO.getExpiredDate(), DateTimeFormatter.ofPattern("yyyyMMdd"));

        if(expiredDate.isBefore(LocalDate.now()) && expiredDate.equals(LocalDate.now())) {
            errors.rejectValue("expiredDate", Status.BAD_REQUEST.name(),"만료 기한은 오늘 날짜 이후로 설정해주세요. ");
        }

        if(licenseDTO.getOverseaCd().name() == null) {
            errors.rejectValue("overseaCd", Status.BAD_REQUEST.name(),"해외여부에 대한 정상적인 값이 아닙니다.");
        }

        if(licenseDTO.getOperCd().name() == null ) {
            errors.rejectValue("operCd", Status.BAD_REQUEST.name(),"운영여부에 대한 정상적인 값이 아닙니다. ");
        }

    }
}
