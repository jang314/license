package com.mnwise.wiseu.license.domain.embedded;

import com.mnwise.wiseu.license.domain.id.ProdId;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="XPROD_INFO_TMP")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@ToString(exclude = "licenses")
public class ProductTmp extends BaseEntity {
    @EmbeddedId
    private ProdId prodId;

//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//    private List<License> licenses = new ArrayList<>();

//    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
//    private List<User> users;


//    public void addLicense(License license) {
//        licenses.add(license);
//        license.setProduct(this);
//    }
}
