package org.launchcode.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping(value = "hello")
public class HelloController {
//handles request at path /hello
//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    // responds to post requests at "/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "GoodBye, Spring!";
    }
    // Responds to get requests at /hello?name=LaunchCoder
    //@GetMapping("hello")
    @RequestMapping(value="hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name,@RequestParam String language){
        String Greeting = HelloController.createMessage(name,language);
        return "<h3 style = 'color:purple;'>" +Greeting + "</h3>";

    }
    // Responds to get requests at /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello,"+ name +"!";
    }
    @GetMapping("form")
    public String helloForm() {
        String html =
                "<html>" +
                        "<body>" +
                        "<form method = 'post' action = '/hello'>" +
                        "<input type = 'text' name = 'name' />" +
                        "<select name = 'language'>" +
                        "<option value = 'English'> English </option>" +
                        "<option value = 'Spanish'> Spanish </option>" +
                        "<option value = 'French'> French </option>" +
                        "<option value = 'German'> German </option>" +
                        "<option value = 'Italian'> Italian </option>" +
                        "</select>" +
                        "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }
    public static String createMessage(String name,String language){
        switch (language){
            case "Spanish":
                return "Hola" + name;
            case "German":
                return "Hallo" + name;
            case "French":
                return "Bonjour" + name;
            case "Italian":
                return "Ciao" + name;
            case "English":
            default:
                return "Hello" + name;
        }
    }
}

