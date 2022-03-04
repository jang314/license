package com.mnwise.wiseu.license.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class CustTypeDTO {
    private Long id;
    @Valid
    @Pattern(regexp = "^[가-힣||[/]]", message = "명명 규칙은 한글 혹은 구분자('/')만 허용 가능합니다.")
    private String name;

    @Builder
    public CustTypeDTO(String name) {
        this.name = name;
    }
}
