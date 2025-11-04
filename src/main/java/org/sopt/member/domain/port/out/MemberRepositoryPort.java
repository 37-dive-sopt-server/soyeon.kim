package org.sopt.member.domain.port.out;

import org.sopt.member.domain.model.Member;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepositoryPort extends JpaRepository<Member, Long> {

    Member save(Member entity);

    Optional<Member> findById(Long id);

    List<Member> findAll();

    boolean existsByEmail(String email);

    void deleteById(Long id);
}
