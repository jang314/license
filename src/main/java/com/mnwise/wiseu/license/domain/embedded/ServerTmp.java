package com.mnwise.wiseu.license.domain.embedded;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mnwise.wiseu.license.domain.code.SID;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Table(name = "XSERVER_INFO_TMP")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@ToString
@Getter
public class ServerTmp extends BaseEntity {

//    @EmbeddedId
//    private ServerId sid;
    @Id
    private String sid;
    private String port;

//    @JsonIgnore
//    private LicenseId licenseId;
//
    @JsonIgnore
//    @MapsId("serverId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "cust_type_id"),
            @JoinColumn(name = "cust_nm"),
            @JoinColumn(name = "product"),
            @JoinColumn(name = "version")
    })
    private LicenseTmp license;

    public ServerTmp makeSid(SID sid, Long idx) {
//        try{
//            this.id = idx > 0 ? sid.name() + "" + String.valueOf(idx) : sid.name();
//        } catch (Exception e){
//          this.id = sid.name();
//        }
        this.port = port;
        return this;
    }

    public void setLicenseTmp(LicenseTmp licenseTmp) {
//        this.license = license;
//        license.getServers().add(this);
    }
}
