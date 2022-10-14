package com.mnwise.wiseu.license.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public class BaseEntity {
    @Column(updatable = false)
    private LocalDateTime insDate;
    private LocalDateTime updDate;

    private String insUser;
    private String updUser;

    @PrePersist
    public void prePersist(){
        LocalDateTime now = LocalDateTime.now();
        insDate = now;
        updDate = now;

    }
    @PreUpdate
    public void preUpdate() {
        updDate = LocalDateTime.now();
    }

}
