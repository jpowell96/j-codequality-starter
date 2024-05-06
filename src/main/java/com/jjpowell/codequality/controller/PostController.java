package com.jjpowell.codequality.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotesController {

    public NotesController() {}

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
