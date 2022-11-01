package com.mnwise.wiseu.license.domain.id;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CustTypeId implements Serializable {
    private Long custTypeId;
    private String name;
}
