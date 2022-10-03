package com.mnwise.wiseu.license.repository;

import com.mnwise.wiseu.license.domain.Cust;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Repository
public class CustJpaRepository {
    private final EntityManager em;

    public void save(Cust cust) {
        em.persist(cust);
    }

    public Cust findOne(String cust) {
        return em.find(Cust.class, cust);
    }
}
