package com.mnwise.wiseu.license.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="XPROD_INFO")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@ToString(exclude = "licenses")
public class Product extends BaseEntity{
    @Id
    @Column(name = "prod_id")
    private String id;

    private String product;
    private String version;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<License> licenses = new ArrayList<>();

    public void addLicense(License license) {
        licenses.add(license);
        license.setProduct(this);
    }
}
