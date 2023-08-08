package io.devlabs.jpa.repository;

import io.devlabs.jpa.entity.Member;

import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id);

}
