package com.springBasic.core.order;

import com.springBasic.core.discount.DiscountPolicy;
import com.springBasic.core.discount.FixDiscountPolicy;
import com.springBasic.core.discount.RateDiscountPolicy;
import com.springBasic.core.member.Member;
import com.springBasic.core.member.MemberRepository;
import com.springBasic.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice){
        Member member = memberRepository.findById(memberId); //회원 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인 적용

        return new Order(memberId, itemName, itemPrice, discountPrice);
        // 주문 결과 반환
    }
}
