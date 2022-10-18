package com.mnwise.wiseu.license.dto.query;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class CustQueryDTO {
    private String custId;
    private Long custTypeId;
    private String custType;
    private String custNm;

    @QueryProjection
    public CustQueryDTO(String custId, String custNm, Long custTypeId , String custType) {
        this.custId = custId;
        this.custNm = custNm;
        this.custTypeId = custTypeId;
        this.custType = custType;
    }
}
