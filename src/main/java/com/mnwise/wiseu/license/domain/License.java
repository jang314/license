package com.mnwise.wiseu.license.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mnwise.wiseu.license.domain.code.OperCd;
import com.mnwise.wiseu.license.domain.code.OverseaCd;
import com.mnwise.wiseu.license.dto.LicenseDTO;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="XLICENSE_INFO")
@Getter
@NoArgsConstructor
@Slf4j
public class License {
    @Id
    @Column(name="license_id")
    private String id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cust_id")
    private Cust cust;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(mappedBy = "license", cascade = CascadeType.ALL)
    private List<Server> servers = new ArrayList<>();
    private String ip;
    private String hostNm;

    @Enumerated(EnumType.STRING)
    private OverseaCd overseaCd; // IN(국내), OUT(해외)

    @Enumerated(EnumType.STRING)
    private OperCd operCd; // OPER(운영), 테스트(TEST)

    private LocalDate expiredDate;

    public License(LicenseDTO licenseDto) {
        this.id = new StringBuffer(licenseDto.getOverseaCd().name())
                .append(licenseDto.getCustId())
                .append(licenseDto.getProduct())
                .append(licenseDto.getOperCd().name())
                .toString();
        this.ip = licenseDto.getIp();
        this.overseaCd = licenseDto.getOverseaCd();
        this.operCd = licenseDto.getOperCd();
        this.expiredDate = LocalDate.parse(licenseDto.getExpiredDate(), DateTimeFormatter.ofPattern("yyyyMMdd"));
        this.hostNm = licenseDto.getHostNm();
        licenseDto.getServers().stream().map(map -> {
            Server server = Server.builder()
                    .port(map.getPort())
                    .build()
                    .makeSid(map.getSid(), map.getIdx())
                    ;
            this.addServer(server);
            return this.servers;
        }).collect(Collectors.toList());
    }

    public void setProduct(Product product) {
        this.product = product;
        product.getLicenses().add(this);
    }
    public void setCust(Cust cust) {
        this.cust = cust;
        cust.getLicenses().add(this);
    }

    public void addServer(Server server) {
        this.servers.add(server);
        server.setLicense(this);
    }

    public License makeLicenseKey(Cust cust, Product product) {
        cust.addLicense(this);
        product.addLicense(this);


        return this;
    }
}
