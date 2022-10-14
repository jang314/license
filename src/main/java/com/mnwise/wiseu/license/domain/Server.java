package com.mnwise.wiseu.license.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mnwise.wiseu.license.domain.code.SID;
import com.mnwise.wiseu.license.dto.ServerDTO;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "XSERVER_INFO")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@ToString
@Getter
public class Server extends BaseEntity{

    @Id
    @Column(name = "sid")
    private String id;
    private String port;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "license_id")
    private License license;

    public Server makeSid(SID sid, Long idx) {
        try{
            this.id = idx > 0 ? sid.name() + "" + String.valueOf(idx) : sid.name();
        } catch (Exception e){
          this.id = sid.name();
        }
        this.port = port;
        return this;
    }

    public void setLicense(License license) {
        this.license = license;
        license.getServers().add(this);
    }
}
