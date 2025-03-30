package com.github.tequilacat.recipe;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("module")
public class TestClass {

    @GetMapping
    public void test() {
        System.out.println("JUCHEEEE");
    }

}
