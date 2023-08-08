package io.devlabs.jpa;

import io.devlabs.jpa.entity.*;
import io.devlabs.jpa.enums.RoleType;
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
            Member user = new Member("jimmy", 20, RoleType.USER);
            Member admin = new Member("kim", 30, RoleType.ADMIN);

            // 회원 등록
            em.persist(user);
            em.persist(admin);

            // 회원 조회
            Member member = em.find(Member.class, 1L);
            System.out.println(member.getUsername());

            Item nike = new Shoes("Infinity run 4", 179000, 10, "Nike", 255);
            Item adidas = new Shoes("Adizero adios 7", 113000, 5, "Adidas", 240);
            Item asics = new Shoes("Gel kayano 30", 189000, 7, "Asics", 270);

            // 상품 등록
            em.persist(nike);
            em.persist(adidas);
            em.persist(asics);

            // 상품 수정
            asics.setPrice(77000);
            System.out.println(asics.getPrice());

            // 상품 조회
            Item item = em.find(Item.class, 3L);
            System.out.println(item.getName());

            // 상품 주문 (재고 감소)
            OrderItem orderItem1 = new OrderItem(adidas, 1);
            OrderItem orderItem2 = new OrderItem(asics, 3);

            Order order = new Order(user, orderItem1, orderItem2);

            em.persist(order);

            System.out.println(orderItem1.getItem().getStock());
            System.out.println(orderItem2.getItem().getStock());

            // 주문내역 조회
            List<OrderItem> orderItems = order.getOrderItems();
            orderItems.stream()
                    .map(OrderItem::getTotalPrice)
                            .forEach(System.out::println);

            // 주문 취소 (재고 원복)
            order.cancel();

            System.out.println(orderItem1.getItem().getStock());
            System.out.println(orderItem2.getItem().getStock());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

}
