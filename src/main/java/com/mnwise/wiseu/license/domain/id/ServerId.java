package com.mnwise.wiseu.license.domain.id;

import com.mnwise.wiseu.license.domain.code.SID;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ServerId implements Serializable {
    private SID sid;
    private Integer idx;
    private LicenseId licenseId;

    public ServerId(SID sid, Integer idx, LicenseId licenseId) {
        this.sid = sid;
        this.idx = idx;
        this.licenseId = licenseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServerId serverId = (ServerId) o;

        if (sid != serverId.sid) return false;
        if (!Objects.equals(idx, serverId.idx)) return false;
        return Objects.equals(licenseId, serverId.licenseId);
    }

    @Override
    public int hashCode() {
        int result = sid != null ? sid.hashCode() : 0;
        result = 31 * result + (idx != null ? idx.hashCode() : 0);
        result = 31 * result + (licenseId != null ? licenseId.hashCode() : 0);
        return result;
    }
}
