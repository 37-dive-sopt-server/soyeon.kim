package org.sopt.member.domain.port.out;

import java.util.List;
import java.util.Optional;
import org.sopt.member.domain.model.Member;

public interface MemberRepository {

    Member save(Member member);
    boolean existsByEmail(String email);
    List<Member> findAll();
    void deleteById(Long id);
    Optional<Member> findById(Long id);
}
