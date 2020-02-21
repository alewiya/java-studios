package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
   /* //@GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "Hello,Spring User!";
    }*/
    @GetMapping("goodbay")
    @ResponseBody
    public String goodbay(){
        return "Goodbay,Spring User!";
    }

    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithParaData(@PathVariable String name){
        return "Hello,"+ name +"Spring User!";
    }


    @GetMapping("form")
    @ResponseBody

    public String helloForm(){
        return "<html>"+
                "<body>"+
                "<form action='hello' method='post'>"+
                "<label>Name</label>"+"<br>"+
                "<input type='text' name='name'>"+"<br>"+"<br>"+
                "<select name='language'>" +
                "<option value='english'selected>English </option>" +
                "<option value='french'>French</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='ahmaric'>Ahmaric</option>" +
                "</select>" +"<br>"+"<br>"+
                "<input type='Submit' Value='Greet Me!'>"+
                "</form>"+
                "</body>"+
                "</html>";

    }

    @RequestMapping(method={RequestMethod.GET,RequestMethod.POST},value="hello")
    @ResponseBody
    public String helloWithQeuryPara(@RequestParam String name,String language){
        String greeting=createMessage(name,language);
        return greeting;
    }
    public static String createMessage(String name,String language ){
        String lang ="";
        if(language.equals("english")){
            lang="Hello";
            return "<h1>"+lang+" "+ name +"!"+ "</h1>";
        }
        else if(language.equals("french")){
            lang="Bonjur";
            return "<h1>"+lang+" "+ name +"!"+ "</h1>";
        }
        else if(language.equals("spanish")){
            lang="Hola";
            return "<h1>"+lang+" "+ name +"!"+ "</h1>";
        }
        else if(language.equals("ahmaric")){
            lang ="Selam";
            return "<h1>"+lang+" "+ name +"!"+ "</h1>";
        }
        return  "<h1>"+lang+" "+ name +"!"+ "</h1>";
    }

}
