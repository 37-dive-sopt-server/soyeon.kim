package org.sopt.member.domain.port.out;

import org.sopt.member.domain.model.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepositoryPort {

    Member save(Member entity);

    Optional<Member> findById(Long id);

    List<Member> findAll();

    boolean existsByEmail(String email);

    void deleteById(Long id);
}
