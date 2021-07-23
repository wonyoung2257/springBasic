package com.springBasic.core.order;

import com.springBasic.core.annotation.MainDiscountPolicy;
import com.springBasic.core.discount.DiscountPolicy;
import com.springBasic.core.discount.FixDiscountPolicy;
import com.springBasic.core.discount.RateDiscountPolicy;
import com.springBasic.core.member.Member;
import com.springBasic.core.member.MemberRepository;
import com.springBasic.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor // final이 붙은 필드의 생성자를 자동으로 만들어줌
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

    public OrderServiceImpl(MemberRepository memberRepository,@MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

//        private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice){
        Member member = memberRepository.findById(memberId); //회원 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인 적용

        return new Order(memberId, itemName, itemPrice, discountPrice);
        // 주문 결과 반환
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
