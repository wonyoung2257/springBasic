package com.springBasic.core;

import com.springBasic.core.member.Grade;
import com.springBasic.core.member.Member;
import com.springBasic.core.member.MemberService;
import com.springBasic.core.member.MemberServiceImpl;

public class MemberApp { // member 확인 클래스

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
