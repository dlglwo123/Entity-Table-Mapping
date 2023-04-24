/*package com.codestates;

import com.codestates.Member2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Configuration
public class JpaColumnMappingConfig {

    private EntityManager em;
    private EntityTransaction tx;

    @Bean
    public CommandLineRunner JpaCreateEntityManager(EntityManagerFactory ef){
        this.em = ef.createEntityManager();
        this.tx = em.getTransaction();

        return args -> {
            //TestEmailNotNull(); // 오류 발생 : not-null property references a null or transient value
            //TestEmailUpdatable(); // 값은 Insert 되었지만 Update 부분에서는 오류가 발생했다.
            TestEmailUnique(); // 동일한 email이 Insert 되면서
        };


    }
    public void TestEmailNotNull(){
        tx.begin();
        em.persist(new Member2()); // nullable : false 즉 null 값을 허용하지않는다.
        tx.commit();
    }
    public void TestEmailUpdatable(){
        tx.begin();
        em.persist(new Member2("dlglwo@naver.com"));
        Member2 member2 = em.find(Member2.class,1L);
        member2.setEmail("dlglwo123@naver.com"); // updatable : false
        tx.commit();
    }
    public void TestEmailUnique(){
        tx.begin();
        em.persist(new Member2("dlglwo123@gmail.com"));
        em.persist(new Member2("dlglwo123@gmail.com"));
        tx.commit();
    }
}

 */