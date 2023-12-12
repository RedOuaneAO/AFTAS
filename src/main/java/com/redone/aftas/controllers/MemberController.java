package com.redone.aftas.controllers;

import com.redone.aftas.dto.MemberRequestDto;
import com.redone.aftas.models.Member;
import com.redone.aftas.services.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class MemberController {
        private final MemberService memberService;

        @PostMapping("Member")
        public Member addMember(@RequestBody MemberRequestDto memberRequestDto){
              return memberService.addNewMember(memberRequestDto);
        }
}
