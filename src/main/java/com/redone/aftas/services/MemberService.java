package com.redone.aftas.services;

import com.redone.aftas.dto.memberDto.MemberRequestDto;
import com.redone.aftas.dto.memberDto.MemberResponseDto;
import com.redone.aftas.models.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {
    Member addNewMember(MemberRequestDto memberRequestDto);

    List<MemberResponseDto> getMembers();
}
