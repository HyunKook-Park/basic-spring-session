package com.sparta.basicspringsession.controller;

import com.sparta.basicspringsession.dto.*;
import com.sparta.basicspringsession.repository.MemberRepository;
import com.sparta.basicspringsession.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<MemberSaveResponseDto> saveMember (@RequestBody MemberSaveRequestDto requestDto){
        return ResponseEntity.ok(memberService.saveMember(requestDto));
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberSimpleResponseDto>> getMembers(){
        return ResponseEntity.ok(memberService.getMembers());
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<MemberDetailResponseDto> getMember(@PathVariable Long id){
        return ResponseEntity.ok(memberService.getMember(id));
    }

    @PutMapping("/member/{id}")
    public ResponseEntity<MemberUpdateResponseDto> updateMember(@PathVariable Long id, @RequestBody MemberUpdateRequestDto requestDto){
        return ResponseEntity.ok(memberService.updateMember(id, requestDto));
    }

    @DeleteMapping("/member/{id}")
    public void deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
    }
}
