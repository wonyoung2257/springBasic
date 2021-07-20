package com.springBasic.core.order;

import com.springBasic.core.AppConfig;
import com.springBasic.core.member.Grade;
import com.springBasic.core.member.Member;
import com.springBasic.core.member.MemberService;
import com.springBasic.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;


    @BeforeEach
    public  void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId =1L;

        Member member = new Member(memberId, "member1", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
