package com.psh.termon;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class Greeting {

    @GetMapping("/gretting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                           Map<String, Object> model) {
        model.put("name", name);
        model.put("title", "hyi");
        return "gretting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        return "main";
    }


}
