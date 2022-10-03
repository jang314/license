package com.mnwise.wiseu.license.repository;

import com.mnwise.wiseu.license.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface ProdRepository extends JpaRepository<Product, String> {

}
