package com.mnwise.wiseu.license.domain;

import com.mnwise.wiseu.license.domain.code.OperCd;
import com.mnwise.wiseu.license.domain.code.OverseaCd;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="XLICENSE_INFO")
@Data
public class License {
    @Id @GeneratedValue
    @Column(name="license_id")
    private String id;

    private LocalDateTime expiredDate;

    @Enumerated(EnumType.STRING)
    private OverseaCd overseaCd; // IN(국내), OUT(해외)

    @Enumerated(EnumType.STRING)
    private OperCd operCd; // OPER(운영), 테스트(TEST)
}
