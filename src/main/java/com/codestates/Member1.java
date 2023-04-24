/*package com.codestates;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Identity : 데이터베이스애서 기본키를 대신 생성해준다.
//Sequence : 엔티티가 영속성 컨텍스트에 저장되기 전에 데이터베이스 시퀀스에서 기본키에 해당하는 값을 제공한다.
@Getter
@Entity
@NoArgsConstructor
public class Member1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Identity 방식은 GenerationType을 Identity 타입으로 지정해줘야 함
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long memberId;

    public Member1(long memberId){
        this.memberId = memberId;
    }
}


 */