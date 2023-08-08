package io.devlabs.jpa.service;

import io.devlabs.jpa.entity.Member;
import io.devlabs.jpa.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long saveMember(Member member) {
        return memberRepository.save(member).getId();
    }

    public Member findMember(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

}
