package com.mnwise.wiseu.license.repository;

import com.mnwise.wiseu.license.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
