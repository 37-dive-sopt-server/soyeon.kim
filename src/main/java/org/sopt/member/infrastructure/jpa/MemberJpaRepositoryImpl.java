package org.sopt.member.infrastructure.jpa;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.sopt.comment.infrastructure.jpa.CommentJpaRepository;
import org.sopt.member.domain.model.Member;
import org.sopt.member.domain.port.out.MemberRepository;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MemberJpaRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository jpa;

    @Override
    public Member save(Member member) {
        return jpa.save(member);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpa.existsByEmail(email);
    }

    @Override
    public List<Member> findAll() {
        return jpa.findAll();
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return jpa.findById(id);
    }

}
