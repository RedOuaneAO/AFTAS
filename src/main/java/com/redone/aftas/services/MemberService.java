package com.redone.aftas.services;

import com.redone.aftas.dto.MemberRequestDto;
import com.redone.aftas.models.Member;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    Member addNewMember(MemberRequestDto memberRequestDto);
}
