package com.mnwise.wiseu.license.repository;

import com.mnwise.wiseu.license.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRespository extends JpaRepository<Member, String> {
}
