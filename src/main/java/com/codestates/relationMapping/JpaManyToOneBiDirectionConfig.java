/*package com.codestates.relationMapping;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;


// 다대일 매핑에 일대다 매핑 추가 구현
@Configuration
public class JpaManyToOneBiDirectionConfig {

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

    private void Example(){
        tx.begin();

        Member member = new Member("dlglwo123@naver.com","leehhe","010-2312-3421");
        Order order = new Order();

        member.addOrder(order); // member.addOrder 함수에 추가해준다.
        // 정상적으로 테이블에 등록은 되지만 find 메서드로 member 객체로 order 그래프를 탐색하면 Order 조회할수 없다.
        // -> find() 메서드가 1차 캐쉬에서 member를 조회하는데 order을 추가해주지 않으면 member 객체가 order 객체를 가지고 있지 않기 때문이다.
        order.addMember(member);
        // 동일하게 member 객체 저장
        // -> 만약 member를 추가하지 않았다면 Order 테이블의 MemberId 값은 null 값이 될것이다.

        em.persist(member);
        em.persist(order);

        tx.commit();

        Member findMember = em.find(Member.class,1L);

        findMember
                .getOrders()
                .stream()
                .forEach(findOrder -> {
                    System.out.println("OrderID : " + findOrder.getOrderID() + " " +
                        "OrderStatus : " + findOrder.getOrderStatus() + " " + findOrder.getCreateAt());
                });

    }
}

 */
