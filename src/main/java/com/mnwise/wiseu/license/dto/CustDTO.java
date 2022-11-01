package com.mnwise.wiseu.license.dto;

import com.mnwise.wiseu.license.domain.Product;
import com.mnwise.wiseu.license.validator.UpdateCheck;
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
    @NotNull(groups = UpdateCheck.class)
    private Long custId;

    @NotNull(message = "고객사 유형을 선택하세요.")
    private Long custType;

    private List<Product> products;

    @NotBlank(message = "고객사 명은 필수 값 입니다.")
    private String name;

    public CustDTO(Long custId, Long custType, String name) {
        this.custId = custId;
        this.name = name;
        this.custType = custType;

    }
}
