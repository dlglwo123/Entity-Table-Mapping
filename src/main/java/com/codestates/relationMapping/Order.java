package com.codestates.relationMapping;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// OrderCoffee 와 Order 관계에서 1에 해당함

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderID;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.ORDER_REQUEST;

    @Column(nullable = false,name = "LAST_MODIFIED_AT")
    private LocalDateTime modifiedAt = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime createAt = LocalDateTime.now();

    // 외래키 역할
    @ManyToOne // 다대일 관게를 나타내는 애너테이션
    @JoinColumn(name = "MEMBER_ID") // Join 애너테이션으로 ORDERS 테이블에서 외래키에 해당하는 값을 할당해준다.
    private Member member;

    public void addMember(Member member){
        this.member = member;
    }

    // 일대다 관계 외래키 역할
    @OneToMany(mappedBy = "order")
    private List<OrderCoffee> orderCoffees = new ArrayList<>();

    public void addOrderCoffee(OrderCoffee orderCoffee){
        orderCoffees.add(orderCoffee);
    }


    public enum OrderStatus{
        ORDER_REQUEST(1, "주문요청"),
        ORDER_CONFIRM(2, "주문 확정"),
        ORDER_COMPLETE(3, "주문 완료"),
        ORDER_CANCEL(4, "주문 취소");

        @Getter
        private int status;
        @Getter
        private String Description;

        OrderStatus(int status, String description) {
            this.status = status;
            Description = description;
        }


    }
}
