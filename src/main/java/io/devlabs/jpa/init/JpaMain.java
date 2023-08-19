package io.devlabs.jpa.init;

import io.devlabs.jpa.entity.Member;
import io.devlabs.jpa.entity.Team;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class JpaMain implements CommandLineRunner {

    private final EntityManager em;

    @Override
    public void run(String... args) throws Exception {
        Team team = new Team();
        team.setName("devLabs");

        em.persist(team);

        Member member = new Member();
        member.setName("jimmy");
        member.setTeam(team);

        em.persist(member);
    }

}
