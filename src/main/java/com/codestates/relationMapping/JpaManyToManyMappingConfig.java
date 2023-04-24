package com.codestates.relationMapping;


import org.aspectj.weaver.ast.Or;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.swing.text.html.parser.Entity;

// 다대다 연관관계 매핑
@Configuration
public class JpaManyToManyMappingConfig {

    private EntityManager em;
    private EntityTransaction tx;

    @Bean
    public CommandLineRunner CreateEntityManager(EntityManagerFactory ef){
        this.em = ef.createEntityManager();
        this.tx = em.getTransaction();

        return args -> {
            Example();
        };
    }

    public void Example(){
        tx.begin();

        Member member = new Member("dlglwo123@naver.com","leeheejae","010-2039-8201");

        // ---------------------------------------------------------------
        Coffee coffee = new Coffee("아이스아메리카노","americano",4500,"AMC");
        Coffee coffee1 = new Coffee("카페라떼","cafe Late",5000,"CAL");
        Order order = new Order();
        Order order1 = new Order();
        OrderCoffee orderCoffee = new OrderCoffee(3); // 아메리카노 개수
        OrderCoffee orderCoffee1 = new OrderCoffee(2); // 카페라떼 개수


        //-----------member와 Order------------

        member.addOrder(order);
        order.addMember(member);

        em.persist(member);

        // -----------------------------------
        coffee.addOrderCoffee(orderCoffee);
        orderCoffee.addCoffee(coffee);

        order.addOrderCoffee(orderCoffee);
        orderCoffee.addOrder(order);
        // ******************************************

        coffee1.addOrderCoffee(orderCoffee1);
        orderCoffee1.addCoffee(coffee1);

        order1.addOrderCoffee(orderCoffee1);
        orderCoffee1.addOrder(order1);

        em.persist(coffee);
        em.persist(order);
        em.persist(orderCoffee);
        em.persist(coffee1);
        em.persist(orderCoffee1);
        em.persist(order1);

        tx.commit();

        Coffee findCoffee = em.find(Coffee.class,1L);
        Coffee findCoffee1 = em.find(Coffee.class,2L);

        findCoffee
                .getOrderCoffees()
                .stream()
                .forEach( findOrder -> {
                    System.out.println("OrderId : " + findOrder.getOrder().getOrderID() + ", OrderStatus : " + findOrder.getOrder().getOrderStatus());
                });
        findCoffee1
                .getOrderCoffees()
                .stream()
                .forEach( findOrder -> {
                    System.out.println("OrderId : " + findOrder.getOrder().getOrderID() + ", OrderStatus : " + findOrder.getOrder().getOrderStatus());
                });
    }
}
