package com.mnwise.wiseu.license.api;


import com.mnwise.wiseu.license.service.LicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LicenseRestController {
    private final LicenseService licenseService;

    @GetMapping(value = "/api/license")
    public LicenseDto save(@RequestBody LicenseDto licenseDto) {

        return licenseDto;
    }

     static class LicenseDto {
        private String product;
        private Long serverId;

     }
}
