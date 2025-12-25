package org.sopt.member.infrastructure.jpa;

import org.sopt.member.domain.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

    boolean existsByEmail(String email);

}
