package io.devlabs.jpa.entity;

import io.devlabs.jpa.enums.RoleType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    private final LocalDateTime createdDate = LocalDateTime.now();

    private LocalDateTime lastModifiedDate;

    @Lob
    private String description;

    public Member(String username, Integer age, RoleType roleType) {
        this.username = username;
        this.age = age;
        this.roleType = roleType;
    }

}
