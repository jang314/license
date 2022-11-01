package com.mnwise.wiseu.license.domain.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LicenseId implements Serializable {
    private CustId custId;
    private ProdId prodId;


    public LicenseId(CustId custId, ProdId prodId) {
        this.custId = custId;
        this.prodId = prodId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LicenseId licenseId = (LicenseId) o;

        if (!Objects.equals(custId, licenseId.custId)) return false;
        return Objects.equals(prodId, licenseId.prodId);
    }

    @Override
    public int hashCode() {
        int result = custId != null ? custId.hashCode() : 0;
        result = 31 * result + (prodId != null ? prodId.hashCode() : 0);
        return result;
    }
}
