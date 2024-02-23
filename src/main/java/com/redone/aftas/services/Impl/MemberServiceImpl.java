package com.redone.aftas.services.Impl;

import com.redone.aftas.dto.UpdateRoleRequest;
import com.redone.aftas.dto.memberDto.MemberRequestDto;
import com.redone.aftas.dto.memberDto.MemberResponseDto;
import com.redone.aftas.models.Member;
import com.redone.aftas.models.Role;
import com.redone.aftas.repositories.MemberRepository;
import com.redone.aftas.services.MemberService;
import com.redone.aftas.services.RoleService;
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
    private final RoleService roleService;
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

    @Override
    public Optional<Member> findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }
    @Override
    public MemberResponseDto findById(int id) {
        Optional<Member> memberOptional = memberRepository.findById(id);
        Member member = memberOptional.orElseThrow(() -> new RuntimeException("The user with Id ( "+id+ " )doesn't Exist"));
        return member.mepToMRDto();
    }
    @Override
    public String updateRole(UpdateRoleRequest updateRoleRequest) {
            MemberResponseDto updatedBy =findById(updateRoleRequest.getUpdatedBy());
            if(updatedBy.getRole().equals("SUPER_ADMIN")){
                Optional<Member> member =memberRepository.findById(updateRoleRequest.getMemberId());
                Role role = roleService.findByRole(updateRoleRequest.getRole());
                member.get().setRole(role);
                memberRepository.save(member.get());
                return "success";
            }

        return "field";
    }
}
