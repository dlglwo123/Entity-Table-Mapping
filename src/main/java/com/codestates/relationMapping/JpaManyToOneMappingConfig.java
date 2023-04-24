/*package com.codestates.relationMapping;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

// 다대일 매핑
@Configuration
public class JpaManyToOneMappingConfig {

    private EntityManager em;

    private EntityTransaction tx;

    @Bean
    public CommandLineRunner CreateEntityManager(EntityManagerFactory ef){

        this.em = ef.createEntityManager();
        this.tx = em.getTransaction();

        return args -> {
            mappingManyToOneUniDirection();
        };
    }

    private void mappingManyToOneUniDirection(){
        tx.begin(); //트렌젝션 시작

        // 객체 생성
        Member member = new Member("dlglwo@naver.com","leeheejae","010-2321-2314");

        em.persist(member); // 1차 캐쉬에 객체 등록

        Order order = new Order(); // order 객체 생성
        order.addMember(member); // order에 있는 Member값에 생성한 객체에 대한 값을 할당한다.
        em.persist(order); // 1차 캐쉬에 order 객체 할당 -> 저장한 화원 정보의 주문 정보를 저장하기 위해서

        tx.commit(); // 쓰기 지연 SQL 저장소에서 삭제

        Order findOrder = em.find(Order.class,1L);

        System.out.println("findOrder : " + findOrder.getMember().getMemberId() + "," + findOrder.getMember().getName() + "," + findOrder.getMember().getPhone());
    }
}
 */