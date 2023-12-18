package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired // MemberController가 생성이 될 때 스프링 컨테이너에 스프링 빈에 등록되어 있는 MemberService 객체와 연결됨 (의존 관계 주입)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
