package com.mnwise.wiseu.license.dto;

import com.mnwise.wiseu.license.domain.code.SID;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Data

public class ServerDTO {
    private SID sid;
    private Long idx;
    private String port;
}
