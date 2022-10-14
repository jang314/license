package com.mnwise.wiseu.license.repository;

import com.mnwise.wiseu.license.domain.CustType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustTypeRepository extends JpaRepository<CustType, Long> {
    boolean existsByName(String name);
}
