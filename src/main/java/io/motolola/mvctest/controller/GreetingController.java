package io.motolola.mvctest.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

/**
 * Created by Akinjide Motolola.
 * email: motolola@icloud.com
 */
@RestController
@RequestMapping("api")
public class GreetingController {

    @GetMapping("/hello")
    public String hello()
    {
        return "Hello World";
    }

    @GetMapping(value = "person", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPerson()
    {
        Person pers = new Person("Mike",20,"Male");
        return pers;
    }

    private class Person {

        private String name;
        private Integer age;
        private String gender;

        public Person(String name, Integer age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }
}
