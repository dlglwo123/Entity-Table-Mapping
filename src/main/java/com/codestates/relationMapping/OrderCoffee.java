package com.codestates.relationMapping;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "ORDERS_COFFEE")
@Getter
@Setter
@NoArgsConstructor
public class OrderCoffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderCoffeeId;

    // Coffee 외래키 역할
    @ManyToOne
    @JoinColumn(name = "COFFEE_ID")
    private Coffee coffee;

    public void addCoffee(Coffee coffee){
        this.coffee = coffee;
    }
    // Order 외래키 역할

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    public void addOrder(Order order){
        this.order = order;
    }
    private int quantity;

    public OrderCoffee(int quantity){
        this.quantity = quantity;
    }
}
