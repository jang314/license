package com.mnwise.wiseu.license.domain.embedded;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mnwise.wiseu.license.domain.code.OperCd;
import com.mnwise.wiseu.license.domain.code.OverseaCd;
import com.mnwise.wiseu.license.domain.id.LicenseId;
import com.mnwise.wiseu.license.dto.LicenseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Entity
@Table(name="XLICENSE_INFO_TMP")
@Getter
@NoArgsConstructor
@Slf4j
public class LicenseTmp {
    @EmbeddedId
    private LicenseId licenseId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("custId")
    @JoinColumns({@JoinColumn(name = "cust_type_id"), @JoinColumn(name = "cust_nm")})
    private CustTmp cust;



    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("prodId")
    @JoinColumns({@JoinColumn(name = "product"), @JoinColumn(name = "version")})
    private ProductTmp product;


//    @OneToMany(mappedBy = "license", cascade = CascadeType.ALL)
//    private List<Server> servers = new ArrayList<>();
    private String ip;
    private String hostNm;

    @Enumerated(EnumType.STRING)
    private OverseaCd overseaCd; // IN(국내), OUT(해외)

    @Enumerated(EnumType.STRING)
    private OperCd operCd; // OPER(운영), 테스트(TEST)

    private LocalDate expiredDate;

    public LicenseTmp(LicenseDTO licenseDto) {

        this.ip = licenseDto.getIp();
        this.overseaCd = licenseDto.getOverseaCd();
        this.operCd = licenseDto.getOperCd();
        this.expiredDate = LocalDate.parse(licenseDto.getExpiredDate(), DateTimeFormatter.ofPattern("yyyyMMdd"));
        this.hostNm = licenseDto.getHostNm();
        licenseDto.getServers().stream().map(map -> {
            ServerTmp server = ServerTmp.builder()
                    .port(String.valueOf(map.getPort()))
                    .build()
                    .makeSid(map.getSid(), map.getIdx())
                    ;
            this.addServer(server);
//            return this.servers;
            return null;
        }).collect(Collectors.toList());
    }

//    public void setProduct(Product product) {
//        this.product = product;
//        product.getLicenses().add(this);
//    }
//    public void setCust(Cust cust) {
//        this.cust = cust;
//        cust.getLicenses().add(this);
//    }

    public void addServer(ServerTmp server) {
//        this.servers.add(server);
        server.setLicenseTmp(this);
    }

//    public License makeLicenseKey(Cust cust, Product product) {
//        cust.addLicense(this);
//        product.addLicense(this);
//        return this;
//    }
}
