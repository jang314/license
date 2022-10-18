package com.mnwise.wiseu.license.dto;

import com.mnwise.wiseu.license.domain.code.SID;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;
import java.util.Map;

@Data
@Valid
public class ServerDTO {

    private SID sid;

    @PositiveOrZero(message = "인덱스 값은 0이상으로 입력해주세요.")
    private Long idx;

    @NotNull(message = "포트는 필수 입력 값 입니다.")
    private Integer port;
}
