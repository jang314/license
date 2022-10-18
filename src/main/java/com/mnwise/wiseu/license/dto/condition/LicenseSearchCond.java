package com.mnwise.wiseu.license.dto.condition;

import com.mnwise.wiseu.license.domain.code.OperCd;
import com.mnwise.wiseu.license.domain.code.OverseaCd;
import lombok.Data;

@Data
public class LicenseSearchCond {
    private Long custType;
    private String cust;
    private String product;
    private String hostNm;
    private String ip;
    private String expiredStartDt;
    private String expiredEndDt;
    private OperCd operCd;
    private OverseaCd overseaCd;

}
