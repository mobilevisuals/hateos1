package com.example.resthateoas;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Greeting extends RepresentationModel<Greeting>
{

    private final String content;

    @JsonCreator
    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
