package com.mnwise.wiseu.license.domain.id;

import com.mnwise.wiseu.license.domain.CustType;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
public class CustId implements Serializable {
    @Column(name = "cust_nm")
    private String name;

    @Column(name = "cust_type_id")
    private Long custTypeId;

    public CustId(String name, Long custTypeId) {
        this.name = name;
        this.custTypeId = custTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustId custId = (CustId) o;

        if (!Objects.equals(name, custId.name)) return false;
        return Objects.equals(custTypeId, custId.custTypeId);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (custTypeId != null ? custTypeId.hashCode() : 0);
        return result;
    }
}
