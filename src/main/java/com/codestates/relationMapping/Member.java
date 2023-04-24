package com.codestates.relationMapping;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
// 다대일 관계에서 1에 해당함
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 키 등록 방식 : JPA에서 자동으로 생성해준다.
    private Long memberId;

    @Column(nullable = false,updatable = false,unique = true)
    private String email;

    @Column(length = 100,nullable = false)
    private String name;

    @Column(length = 13,nullable = false,unique = true)
    private String phone;

    @Column(nullable = false,name = "LOCAL_MODIFIED_AT")
    private LocalDateTime localDateTime = LocalDateTime.now();

    @OneToMany(mappedBy = "member") // 일대다 관계 매핑 : mappedBy : Order 클래스에서 외래키의 역할을 하고 있는 필드값
    private List<Order> orders = new ArrayList<>();

    @Transient
    private String age;

    public Member(String email){
        this.email = email;
    }

    public Member(String email,String name,String phone){
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

    public void addOrder(Order order){
        orders.add(order); // List 형식이기 때문에 add 추가
    }
}
/*
    mappedBy 애트리뷰트 설명

    - mappedBy 값은 관계를 소유하고 있는 필드를 지정하는것으로 이해가능하다.
    - 두 객체들 간에 외래키의 역할을 하는 필드는 무엇인가?
    - 외래키의 역할을 하는 필드는 다(N)에 클래스안에 존재한다.
 */
