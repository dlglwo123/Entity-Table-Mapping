/*package com.codestates;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.lang.reflect.Member;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;

    @Column(nullable = false,updatable = false,unique = true)
    private String email;

    //email 은 거의 필수 항목으로 간주되기 때문에 Null 값을 허용하지 않는다: nullable : false
    //email 수정 불가 : false
    //email 고유한 값 :  유니크 제약 조건 : true

    private LocalDateTime localDateTime = LocalDateTime.now();
    // LocalDateTime : 회원 정보가 등록될 때 시간 및 날짜를 매핑하기 위한 필드이다.
    // LocalDateTime은 열의 TimeStamp 타입과 매핑된다.

    @Transient // 테이블 열과 매핑하지 않겠다는 애너테이션
    // 데이터 베이스에 저장 X 조회 역시 매핑 X
    // 임시데이터 메모리에서 사용하기 위한 용도로 사용된다.
    private String age;

    public Member2(String email){
        this.email = email;
    }
}
 */

/*
    @Column : 필드와 열을 매핑해주는 애너테이션이다.
    만일 Column 애너테이션이 없고 필드만 정의 되어있다면 JPA는 기본적으로 이 필드가 테이블의 열과 매핑되는 필드라고 간주하게 된다.
    @Column 애너테이션만 추가하고 아무런 제약사항을 주지 않는다면 디폹트 값으로 설정된다.

    애트리뷰트
    nullable : 열에 null 값을 허용할지 여부, 디폴트 값 : true
    updatable : 테이블을 수정할 수 있는지 없는지의 여부 : 디폴트값 : true
    unique : 하나의 열에 유니크 제약 조건을 건다. , 디폴트값 : false
    length : 열에 저장할 수 있는 문자 길이 , 디폴트값 : 255
    name : 다른 이름의 열로 바꿀수 있다. 디폴트 값 : 엔티티 클래스 필드이름

    추가적인 애너테이션
    @Enumerated : enum 타입과 매핑할때 사용하는 애너테이션
    - EnumType.ORDINAL : enum 순서를 나타내는 숫자를 테이블에 저장한다.
    - EnumType.STRING : enum의 이름을 테이블에 저장한다.
    -> ORDINAL 이라는 메서드는 enum 상수사이에 값을 추가하거나 이미 사용한 정수에 대응되는 새로운 Enum 상수값을 사용할 수 없는 문제점이 있다.


   ******* 주의 사항 *********
   @Column 애너테이션이 생략 및 애트리뷰트 기본값을 사용할 경우

   원시타입(int, long) => 애너테이션 생략 시 기본적으로 nullable = false
 */
