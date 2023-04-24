/*package com.codestates;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

// Identity 방식
@Configuration
public class JpaIdentityMappingConfigure {

    private EntityManager em;

    private EntityTransaction tx;

    @Bean
    public CommandLineRunner createEntityManager(EntityManagerFactory ef){
        this.em = ef.createEntityManager(); // 매니저 생성

        this.tx = em.getTransaction();

        return args -> {
            tx.begin();
            em.persist(new Member1()); // 객체 1차 캐쉬에 저장
            tx.commit();


            Member1 member1 = em.find(Member1.class,1L);
            System.out.println("memberId : " + member1.getMemberId());
        };
    }
}
 */