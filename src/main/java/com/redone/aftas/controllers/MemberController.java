package com.redone.aftas.controllers;

import com.redone.aftas.dto.memberDto.MemberRequestDto;
import com.redone.aftas.dto.memberDto.MemberResponseDto;
import com.redone.aftas.models.Member;
import com.redone.aftas.services.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class MemberController {
        private final MemberService memberService;

        @PostMapping("Member")
        public Member addMember(@RequestBody MemberRequestDto memberRequestDto){
              return memberService.addNewMember(memberRequestDto);
        }
        @GetMapping("Members")
        public List<MemberResponseDto> getMembers(){
            return  memberService.getMembers();
        }
}
