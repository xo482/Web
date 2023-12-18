package hello.hellospring; // 컴포넌트 스캔할 때 여기 안에 있는 애들만 스프링이 뒤진다.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	// 여기서부터 모든 실행이 시작된다.
	public static void main(String[] args) {
		// 이게 실행되면 run을 해서 HelloSpringApplication을 실행하는데
		// 얘가 내장하고 있는 Tomcat이라는 웹서버가 같이 실행
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
