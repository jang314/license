package com.mnwise.wiseu.license.dto;


import com.mnwise.wiseu.license.domain.License;
import com.mnwise.wiseu.license.domain.code.OperCd;
import com.mnwise.wiseu.license.domain.code.OverseaCd;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
public class LicenseDTO {
    private String custId;
    private String product;
    private List<ServerDTO> servers;
    private String ip;
    private String hostNm;
    private OverseaCd overseaCd;
    private OperCd operCd;
    private String expiredDate;
}
