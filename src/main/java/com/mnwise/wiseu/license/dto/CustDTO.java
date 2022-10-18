package com.mnwise.wiseu.license.dto;

import com.mnwise.wiseu.license.domain.Product;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@Valid
public class CustDTO {
    private String custId;

    @NotNull(message = "고객사 유형을 선택하세요.")
    private Long custType;

    private List<Product> products;

    @NotBlank(message = "고객사 명은 필수 값 입니다.")
    private String name;

    public CustDTO(String custId, Long custType, String name) {
        this.custId = custId;
        this.name = name;
        this.custType = custType;

    }
}
