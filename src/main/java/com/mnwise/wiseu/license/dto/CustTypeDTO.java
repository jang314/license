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
    private String name;

}

