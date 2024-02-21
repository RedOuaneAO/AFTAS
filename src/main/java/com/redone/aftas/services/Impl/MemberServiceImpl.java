package com.redone.aftas.services.Impl;

import com.redone.aftas.dto.memberDto.MemberRequestDto;
import com.redone.aftas.dto.memberDto.MemberResponseDto;
import com.redone.aftas.models.Member;
import com.redone.aftas.repositories.MemberRepository;
import com.redone.aftas.services.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    @Override
    public Member addNewMember(MemberRequestDto memberRequestDto) {
        Optional<Member> memberExist = memberRepository.findByIdentityNumber(memberRequestDto.getIdentityNumber());
        if(memberExist.isPresent()){
            throw new RuntimeException("this Member is already registered");
        }
        Member member = memberRequestDto.mapToMemberEntity();
        member.setAccessionDate(new Date());
        return memberRepository.save(member);
    }

    @Override
    public List<MemberResponseDto> getMembers() {
        return memberRepository.findAll().stream().map(member -> member.mepToMRDto()).collect(Collectors.toList());
    }

    @Override
    public MemberResponseDto save(Member user) {
        return memberRepository.save(user).mepToMRDto();
    }
}
