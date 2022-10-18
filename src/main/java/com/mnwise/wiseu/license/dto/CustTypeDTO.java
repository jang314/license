package com.mnwise.wiseu.license.dto;

import com.mnwise.wiseu.license.domain.CustType;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@Valid
@Getter
public class CustTypeDTO {
    private Long id;
    @NotBlank(message = "고객사 유형 명은 필수 입력 값입니다. ")
    @Pattern(regexp = "^([가-힣]*(/)?[가-힣]*){2}$", message = "고객사 명은 구분자('/', 최대 2개)를 포함한 한글이어야 합니다.")
    private String name;

    @Builder
    @QueryProjection
    public CustTypeDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

