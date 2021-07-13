package com.springBasic.core.discount;

import com.springBasic.core.member.Member;

public interface DiscountPolicy {
    /**
     *
     *
     * @param price
     * @return 할인 대상 금액
     */

    int discount(Member member, int price);
}
