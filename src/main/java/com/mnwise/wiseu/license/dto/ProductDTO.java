package com.mnwise.wiseu.license.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@Valid
public class ProductDTO {
    @NotBlank(message = "제품 명은 필수 입력 값 입니다.")
    private String name;

    @NotBlank(message = "제품 버전은 필수 입력 값 입니다.")
    private String version;

    @QueryProjection
    public ProductDTO(String name, String version) {
        this.name = name;
        this.version = version;
    }
}
