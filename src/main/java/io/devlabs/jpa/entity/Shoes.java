package io.devlabs.jpa.entity;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Shoes extends Item {

    private String brand;
    private int size;

    public Shoes(String name, int price, int stock, String brand, int size) {
        super(name, price, stock);
        this.brand = brand;
        this.size = size;
    }

}
