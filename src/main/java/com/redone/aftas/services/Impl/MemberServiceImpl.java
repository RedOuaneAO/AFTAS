package com.redone.aftas.services.Impl;

import com.redone.aftas.dto.MemberRequestDto;
import com.redone.aftas.models.Member;
import com.redone.aftas.repositories.MemberRepository;
import com.redone.aftas.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Override
    public Member addNewMember(MemberRequestDto memberRequestDto) {
        Member member = memberRequestDto.mapToMemberEntity();
        member.setAccessionDate(new Date());
        return memberRepository.save(member);
    }
}
