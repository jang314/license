package com.mnwise.wiseu.license.repository;

import com.mnwise.wiseu.license.domain.CustType;
import com.mnwise.wiseu.license.dto.CustTypeDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CustTypeRepository {
    private final EntityManager em;

    /* CRUD */
    public void save(CustType custType){

        em.persist(custType);
    }


    public List<CustType> findByName(String name) {

        return em.createQuery("select type from CustType type where type.name like :name", CustType.class)
            .setParameter("name", "%"+name+"%")
            .getResultList();
    }

    public CustType findOne(Long id) {
        return em.find(CustType.class, id);
    }
}
