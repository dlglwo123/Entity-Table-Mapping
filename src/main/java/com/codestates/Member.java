/*package com.codestates;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
// 기본키 직접 할당 방식
@Entity(name = "USERS") // (필수) Entity 매핑 애너테이션을 이용하여 엔티티 클래스와 테이블을 매핑 : JPA 관리 대상 엔티티
        // 애트리뷰트 : name을 이용해서 엔티티 이름을 설정할 수 있다.
@Table(name = "USERS") // 테이블 이름을 변경해주는 에너테이션
@NoArgsConstructor // 파라미터가 없은 기본생성자는 필수로 추가해야한다 : 기본생성자가 없는 경우 에러가 발생할 수 있음
@Getter
// 애트리뷰트 설명
// name 애트리뷰트를 설정하지 않으면 기본값으로 클래스 이름을 테이블 이름으로 사용한다.
public class Member {
    @Id //(필수)
    private Long memberId;

    public Member(Long memberId){
        this.memberId = memberId;
    }
}

 */

/* 기본키 매핑

    데이터베이스에서 테이블에 기본키 설정은 필수이다.
    JPA 에서는 기본적으로 @Id 애너테이션을 추가한 필드가 기본 키 열이 된다.

    기본키 생성 전략

    - 기본키 직접 할당 : 애플리케이션 코드 상에서 기본키를 직접 할당해주는 방식




 */