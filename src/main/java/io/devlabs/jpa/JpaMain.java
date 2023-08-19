package io.devlabs.jpa;

import io.devlabs.jpa.entity.Member;
import io.devlabs.jpa.entity.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Team team = new Team();
            team.setName("teamA");

            em.persist(team);

            Member member1 = new Member();
            member1.setName("JIMMY");
            member1.setTeam(team);

            Member member2 = new Member();
            member2.setName("KIM");
            member2.setTeam(team);

            em.persist(member1);
            em.persist(member2);

            System.out.println(member1.getTeam().getName());

            Team findTeam = em.find(Team.class, team.getId());
            System.out.println(findTeam);

            List<Member> members = findTeam.getMembers();
            members.forEach(member -> System.out.println(member.getName()));

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

}
