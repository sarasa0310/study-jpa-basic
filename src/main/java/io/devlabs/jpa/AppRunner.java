package io.devlabs.jpa;

import io.devlabs.jpa.entity.Member;
import io.devlabs.jpa.enums.RoleType;
import io.devlabs.jpa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AppRunner implements CommandLineRunner {

    private final MemberService memberService;

    @Autowired
    public AppRunner(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public void run(String... args) throws Exception {
//        Member user = new Member();
//        user.setAge(20);
//        user.setUsername("jimmy");
//        user.setCreatedDate(LocalDateTime.now());
//        user.setRoleType(RoleType.USER);
//
//        Member admin = new Member();
//        admin.setAge(30);
//        admin.setUsername("kim");
//        admin.setCreatedDate(LocalDateTime.now());
//        admin.setRoleType(RoleType.ADMIN);
//
//        memberService.saveMember(user);
//        memberService.saveMember(admin);
    }

}
