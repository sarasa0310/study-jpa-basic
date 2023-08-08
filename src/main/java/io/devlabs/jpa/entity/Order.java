package io.devlabs.jpa.entity;

import io.devlabs.jpa.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    private final LocalDateTime orderDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.REQUEST;

    public Order(Member member, OrderItem... orderItems) {
        this.member = member;
        for (OrderItem orderItem : orderItems) {
            this.addOrderItem(orderItem);
        }
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.addOrder(this);
    }

    public void cancel() {
        if (status != OrderStatus.REQUEST) {
            throw new IllegalStateException("이미 완료 또는 취소된 주문은 취소가 불가능합니다.");
        }
        status = OrderStatus.CANCEL;
        orderItems.forEach(OrderItem::cancel);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
    private List<OrderItem> orderItems = new ArrayList<>();

}
