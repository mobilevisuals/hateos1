package com.example.resthateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.MathContext;
import java.util.Random;

@RestController
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping("/greeting")
    public HttpEntity<Greeting> greeting(
            @RequestParam(value = "name",
                    defaultValue = "World") String name) {

        Greeting greeting = new Greeting(String.format(TEMPLATE, name));
        greeting.add(linkTo(methodOn(GreetingController.class).
                greeting(name)).withSelfRel());

        greeting.add(linkTo(methodOn(GreetingController.class).
                randomNumberGreeting()).withRel("random_number"));

        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }

    @RequestMapping("/random")
    public HttpEntity<Double> randomNumberGreeting() {
        double result = 0;
        Random random = new Random();
        double rand1 = random.nextDouble();
        double rand2 = random.nextDouble();
        result = Math.pow(rand1, rand2);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
