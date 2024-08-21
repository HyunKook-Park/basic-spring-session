package com.sparta.basicspringsession.service;

import com.sparta.basicspringsession.dto.MemberSaveRequestDto;
import com.sparta.basicspringsession.dto.MemberSaveResponseDto;
import com.sparta.basicspringsession.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

}
