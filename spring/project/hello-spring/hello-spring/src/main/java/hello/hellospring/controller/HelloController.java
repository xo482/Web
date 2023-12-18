package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // 해당 주소로 이동하게 되면 호출되어 실행되는 함수
    @GetMapping("hello")
    public String hello(Model model){ // 스프링이 model에 값을 넣어준다.
        // 변수 이름은 data이고 값은 hello!!이다. 이걸 hello.html에 넘겨준다.
        model.addAttribute("data", "hello!!");

        // 스프링(viewResolver)이 resources\templates\ 밑에서 hello.html를 찾고 얘한테 가서 렌더링한다는 의미
        return "hello";
    }

    // MVC 방식으로 데이터 전달
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name", name);

        return "hello-template";
    }

    // API 방식으로 데이터 전달
    // @ResponseBody 문자 반환
    @GetMapping("hello-string")
    @ResponseBody // http 프로토콜의 body부에 내가 이 데이터를 직접 넣어주겠다는 뜻
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    // API 방식으로 데이터 전달
    // @ResponseBody 객체 반환
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        // ✔ alt + ins 로 생성자 또는 게터, 세터 등 프로퍼티 생성할 수 있음
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
