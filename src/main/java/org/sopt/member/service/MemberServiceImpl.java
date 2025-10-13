package org.sopt.member.service;

import java.util.List;
import java.util.Optional;
import org.sopt.member.domain.Member;
import org.sopt.member.repository.MemoryMemberRepository;
import org.sopt.member.service.dto.MemberJoinCommand;

public class MemberServiceImpl implements MemberService {

    private final MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public Long join(MemberJoinCommand memberJoinCommand) {
        Member member = Member.of(
            memberJoinCommand.name(),
            memberJoinCommand.birthday(),
            memberJoinCommand.email(),
            memberJoinCommand.gender()
        );
        Member savedMember = memberRepository.save(member);
        return savedMember.getId();
    }

    @Override
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    @Override
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }
}
