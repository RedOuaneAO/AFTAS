package com.redone.aftas.services.Impl;

import com.redone.aftas.dto.MemberRequestDto;
import com.redone.aftas.models.Member;
import com.redone.aftas.repositories.MemberRepository;
import com.redone.aftas.services.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    @Override
    public Member addNewMember(MemberRequestDto memberRequestDto) {
        Optional<Member> memberExist = memberRepository.findById(memberRequestDto.getMemberNum());
        if(memberExist.isPresent()){
            throw new RuntimeException("this number is already registered to another member");
        }
        Member member = memberRequestDto.mapToMemberEntity();
        member.setAccessionDate(new Date());
        return memberRepository.save(member);
    }
}
