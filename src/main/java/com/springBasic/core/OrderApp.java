package com.springBasic.core;

import com.springBasic.core.member.Grade;
import com.springBasic.core.member.Member;
import com.springBasic.core.member.MemberService;
import com.springBasic.core.member.MemberServiceImpl;
import com.springBasic.core.order.Order;
import com.springBasic.core.order.OrderService;
import com.springBasic.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId =1L;

        Member member = new Member(memberId, "member1", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
