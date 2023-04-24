/*package com.codestates;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
// 기본키 직접 할당 방식
@Configuration
public class JpaDirectMappingConfig {
    private EntityManager em;

    private EntityTransaction tx;

    @Bean
    public CommandLineRunner CreateEntityManager(EntityManagerFactory ef){
        this.em = ef.createEntityManager();

        this.tx = em.getTransaction();

        return args -> {
            tx.begin();
            em.persist(new Member(1L)); // 영속성 컨텍스트에 객체 정보 할당 <- 기본키 직접 할당을 하고 있다.
            tx.commit();
            Member member = em.find(Member.class, 1L);
            System.out.println("memberId  : " + member.getMemberId());
        };
    }
}

 */
