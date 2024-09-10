package hi.hi_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

//    @GetMapping("hello")
//    public String hello(Model model) {
//        model.addAttribute("data", "hello!"); // 키 & 밸류
//        // 즉, html문서 내의 data 부분이 hello로 치환되어 렌더링 된다는 뜻이다.
//
//        return "hello"; // hello.html 리턴.
//    }

    @GetMapping("hello-mvc")
    // 이제 동적인 방식으로, RequestParam은 URL 뒤의 ?name=@@@ 부분을 동적으로 받아와 렌더링한다.
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name); // 키 & 밸류(위 코드에서 설정)
        return "hello-template";
    }

    @GetMapping("hello-api")
    @ResponseBody // https의 body부에 직접 데이터를 넣기 위한 어노테이션.
    // 동적 - 🌟 API방식
    public String helloApi(@RequestParam("name") String name) {
        return "hello " + name; // 여기서부터는 html로 렌더링하는게 아닌 https의 body부에 직접 주입.
    }

    @GetMapping("hello-api-json")
    @ResponseBody // https의 body부에 직접 데이터를 넣기 위한 어노테이션.
    // 동적 - 🌟🌟🌟 API방식 : "JSON"
    public String helloApiJson(@RequestParam("name") String name) {

    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
