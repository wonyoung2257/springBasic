package com.springBasic.core;

import com.springBasic.core.discount.DiscountPolicy;
import com.springBasic.core.discount.FixDiscountPolicy;
import com.springBasic.core.discount.RateDiscountPolicy;
import com.springBasic.core.member.MemberService;
import com.springBasic.core.member.MemberServiceImpl;
import com.springBasic.core.member.MemoryMemberRepository;
import com.springBasic.core.order.OrderService;
import com.springBasic.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
//        return null;
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
