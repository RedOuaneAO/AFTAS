package com.redone.aftas.services;

import com.redone.aftas.dto.memberDto.MemberRequestDto;
import com.redone.aftas.dto.memberDto.MemberResponseDto;
import com.redone.aftas.models.Member;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MemberService {
    Member addNewMember(MemberRequestDto memberRequestDto);

    List<MemberResponseDto> getMembers();

    MemberResponseDto save(Member user);

    Optional<Member> findByEmail(String email);
}
