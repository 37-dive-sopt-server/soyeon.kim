package org.sopt.member.infrastructure;

import java.time.Instant;
import org.sopt.member.domain.model.Member;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.sopt.member.domain.port.out.MemberRepositoryPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Qualifier("memoryMemberRepository")
@Repository
public class MemoryMemberRepository implements MemberRepositoryPort {

    private final Map<Long, Member> store = new ConcurrentHashMap<>();
    private final Set<String> emails = new LinkedHashSet<>();
    private final AtomicLong sequence = new AtomicLong(1);

    @Override
    public Member save(Member member) {
        Instant now = Instant.now();
        if (member.getId() == null) {
            member.updateId(sequence.getAndIncrement());
            member.updateCreatedAt(now);
        }
        member.updateUpdatedAt(now);
        store.put(member.getId(), member);
        emails.add(member.getEmail());
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public boolean existsByEmail(String email) {
        return emails.contains(email);
    }

    @Override
    public void deleteById(Long id) {
        if(id == null) {
            throw new IllegalArgumentException("id는 빈 값일 수 없습니다.");
        }
        if (!store.containsKey(id)) {
            throw new NoSuchElementException("id " + id + "번으로 등록된 회원이 존재하지 않습니다.");
        }
        store.remove(id);
    }
}