package com.mnwise.wiseu.license.dto.query;


import com.querydsl.core.annotations.QueryProjection;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class LicenseQueryDTO {
    private String licenseId;
    private String hostNm;
    private String ip;
    private String product;
    private String version;
    private LocalDate expriedDate;
    private String custNm;
    private String custType;


    @QueryProjection
    @Builder
    public LicenseQueryDTO(String licenseId, String hostNm, String ip, String product, String version, LocalDate expriedDate, String custNm, String custType) {
        this.licenseId = licenseId;
        this.hostNm = hostNm;
        this.ip = ip;
        this.product = product;
        this.version = version;
        this.expriedDate = expriedDate;
        this.custNm = custNm;
        this.custType = custType;
    }
}
