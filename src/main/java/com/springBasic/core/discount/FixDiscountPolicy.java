package com.springBasic.core.discount;

import com.springBasic.core.member.Grade;
import com.springBasic.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int DiscountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {

        if(member.getGrade() == Grade.VIP){
            return DiscountFixAmount;
        }else{
            return 0;
        }
    }
}
