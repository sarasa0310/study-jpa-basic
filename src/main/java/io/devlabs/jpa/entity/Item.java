package io.devlabs.jpa.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stock;

    public Item(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void addStock(int count) {
        stock += count;
    }

    public void reduceStock(int count) {
        int result = stock - count;
        if (result < 0) {
            throw new IllegalStateException("재고가 부족합니다.");
        }
        stock = result;
    }

}
