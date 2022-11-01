package com.mnwise.wiseu.license.domain.id;

import com.mnwise.wiseu.license.domain.code.Prod;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
public class ProdId implements Serializable {
    @Enumerated
    @Column(name = "product")
    private Prod prod;
    private String version;

    public ProdId(Prod prod, String version) {
        this.prod = prod;
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProdId prodId = (ProdId) o;

        if (prod != prodId.prod) return false;
        return Objects.equals(version, prodId.version);
    }

    @Override
    public int hashCode() {
        int result = prod != null ? prod.hashCode() : 0;
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }
}
