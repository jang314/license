package com.mnwise.wiseu.license.api;


import com.mnwise.wiseu.license.domain.License;
import com.mnwise.wiseu.license.dto.LicenseDTO;
import com.mnwise.wiseu.license.service.LicenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LicenseRestController {
    private final LicenseService licenseService;

    /*
    * 라이센스 등록 시 고객사와 제품은 필수 선택하고,
    * 서버 정보와 프로세스 엔진명은 입력받아 같이 저장되게 한다.
    * */

    @PostMapping(value = "/api/license")
    public License save(@RequestBody LicenseDTO licenseDto) {
        return licenseService.save(licenseDto);
    }
}
