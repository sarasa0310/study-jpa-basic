package io.devlabs.jpa.init;

import io.devlabs.jpa.entity.Locker;
import io.devlabs.jpa.entity.Member;
import io.devlabs.jpa.entity.Team;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
@RequiredArgsConstructor
public class JpaMain implements CommandLineRunner {

    private final EntityManager em;

    @Override
    public void run(String... args) throws Exception {
        Team team = new Team();
        team.setName("myTeam");

        em.persist(team);

        Locker locker = new Locker();
        locker.setName("myLocker");

        em.persist(locker);

        Member member1 = new Member();
        member1.setName("jimmy");
        member1.setTeam(team);
        member1.setLocker(locker);

        Member member2 = new Member();
        member2.setName("dubu");
        member2.setTeam(team);

        em.persist(member1);
        em.persist(member2);

        List<Member> members = team.getMembers();
        for (Member member : members) {
            System.out.println("member = " + member);
        }
    }

}
