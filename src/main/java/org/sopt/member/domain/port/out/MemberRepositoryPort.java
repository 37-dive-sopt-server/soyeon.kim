package org.sopt.member.domain.port.out;

import org.sopt.member.domain.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepositoryPort extends JpaRepository<Member, Long> {

    boolean existsByEmail(String email);

}
