package com.codestates.relationMapping;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
// OrderCoffee - Coffee 관계 : 1대 다 관계에서 1에 해당함
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long coffeeId;

    @Column(length = 50,nullable = false)
    private String korName;
    @Column(length = 50,nullable = false)
    private String engName;
    @Column(nullable = false)
    private int price;

    // 외래키 역할
    @OneToMany(mappedBy = "coffee")
    private List<OrderCoffee> orderCoffees = new ArrayList<>();

    public void addOrderCoffee(OrderCoffee orderCoffee){
        orderCoffees.add(orderCoffee);
    }

    @Column(nullable = false,length = 3)
    private String CoffeeCode;

    @Column(nullable = false)
    private LocalDateTime ModifiedAt = LocalDateTime.now();

    @Column(nullable = false, name = "LAST_MODIFIED_AT")
    private LocalDateTime CreateAt = LocalDateTime.now();

    public Coffee(String korName, String engName, int price,String CoffeeCode){
        this.korName = korName;
        this.engName = engName;
        this.price = price;
        this.CoffeeCode = CoffeeCode;
    }
}
