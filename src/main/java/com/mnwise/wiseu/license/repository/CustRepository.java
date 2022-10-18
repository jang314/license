package com.mnwise.wiseu.license.repository;

import com.mnwise.wiseu.license.domain.Cust;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustRepository extends JpaRepository<Cust, String> {
    boolean existsByNameAndCustTypeId(String name, Long custTypeId);
    boolean existsById(String custId);
}
