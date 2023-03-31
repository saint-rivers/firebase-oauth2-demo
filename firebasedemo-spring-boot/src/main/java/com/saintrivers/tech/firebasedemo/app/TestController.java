package com.saintrivers.tech.firebasedemo.app;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TestController {

    record Message(String message) {
    }

    @GetMapping("/api/public")
    public Message publicRoute() {
        return new Message("public route");
    }

    @GetMapping("/api/private")
    public Message privateRoute() {
        return new Message("private route route");
    }
}
