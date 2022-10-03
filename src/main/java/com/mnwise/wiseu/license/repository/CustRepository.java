package com.mnwise.wiseu.license.repository;

import com.mnwise.wiseu.license.domain.Cust;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustRepository extends JpaRepository<Cust, String> {
}
