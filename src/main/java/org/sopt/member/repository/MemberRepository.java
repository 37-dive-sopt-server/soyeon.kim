package org.sopt.member.repository;

import org.sopt.member.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member entity);

    Optional<Member> findById(Long id);

    List<Member> findAll();

    boolean existsByEmail(String email);
}