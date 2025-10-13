package org.sopt.member.repository;

import java.time.Instant;
import org.sopt.member.domain.Member;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MemoryMemberRepository implements MemberRepository {

    private final Map<Long, Member> store = new ConcurrentHashMap<>();
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
}