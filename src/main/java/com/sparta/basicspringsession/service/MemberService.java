package com.sparta.basicspringsession.service;

import com.sparta.basicspringsession.dto.MemberDetailResponseDto;
import com.sparta.basicspringsession.dto.MemberSaveRequestDto;
import com.sparta.basicspringsession.dto.MemberSaveResponseDto;
import com.sparta.basicspringsession.dto.MemberSimpleResponseDto;
import com.sparta.basicspringsession.entity.Member;
import com.sparta.basicspringsession.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberSaveResponseDto saveMember(MemberSaveRequestDto requestDto){
        Member member = new Member(requestDto.getName());
        Member savedMember = memberRepository.save(member);
        return new MemberSaveResponseDto(member.getId(), member.getName());
    }

    public List<MemberSimpleResponseDto> getMembers(){
        List<Member> members = memberRepository.findAll();
        List<MemberSimpleResponseDto> memberList = new ArrayList<>();
        for (Member member : members) {
            MemberSimpleResponseDto responseDto = new MemberSimpleResponseDto(member.getName());
            memberList.add(responseDto);
        }
        return memberList;
    }

    public MemberDetailResponseDto getMember(Long id){
        Member member = memberRepository.findById(id).orElseThrow(()->new NullPointerException("id is not found"));
        return new MemberDetailResponseDto(member.getId(),member.getName());
    }


}
