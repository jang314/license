package com.mnwise.wiseu.license.dto;


import com.mnwise.wiseu.license.domain.License;
import com.mnwise.wiseu.license.domain.code.OperCd;
import com.mnwise.wiseu.license.domain.code.OverseaCd;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.*;
import java.util.List;

@Getter
public class LicenseDTO {
    @NotNull(message = "고객사는 필수 선택 사항입니다.")
    private Long custId;

    @NotNull(message = "제품은 필수 선택 사항입니다.")
    private String product;

    @Size(min = 1, message = "서버 정보를 입력하세요.")
    private List<ServerDTO> servers;

    @NotBlank(message = "아이피는 필수 입력 값입니다.")
    @Pattern(regexp = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$", message = "올바르지 않은 IP형식입니다.")
    private String ip;

    private String hostNm;

    private OverseaCd overseaCd;
    private OperCd operCd;

    @NotBlank(message = "만료기한은 필수 입력 값입니다.")
    private String expiredDate;
}
