package com.mnwise.wiseu.license.dto;

import com.mnwise.wiseu.license.domain.Cust;
import com.mnwise.wiseu.license.domain.CustType;
import com.mnwise.wiseu.license.validator.UpdateCheck;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@Valid
@Getter
public class CustTypeDTO {
    @NotNull(groups = UpdateCheck.class, message = "고객사 ID는 필수 값입니다.")
    private Long id;
    @NotBlank(message = "고객사 유형 명은 필수 입력 값입니다. ")
    @Pattern(regexp = "^([가-힣]*(/)?[가-힣]*){2}$", message = "고객사 명은 구분자('/', 최대 2개)를 포함한 한글이어야 합니다.")
    private String name;

    @QueryProjection
    public CustTypeDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Builder
    public CustTypeDTO(CustType custType) {
        this.id = custType.getId();
        this.name = custType.getName();
    }
}

