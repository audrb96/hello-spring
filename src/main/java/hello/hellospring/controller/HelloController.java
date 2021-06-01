package hello.hellospring.controller;

import hello.hellospring.HelloSpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","spring!!");
        return "hello";
    }

    //MVC 방식
    //데이터를 template에서 찾아서 html로 내려보낸다.


    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name",name);

        return "hello-template";
    }

    //api 방식
    //데이터를 그대로 내려보낸다.
    //@ResponseBody

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){

        return "hello " + name;
    }


    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
        //객체를 내리면 JSON방식으로 내린다.


    }



    static class Hello{
        private String name;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
