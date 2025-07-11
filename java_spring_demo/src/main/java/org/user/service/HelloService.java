package org.user.service;

import org.springframework.stereotype.Component;

@Component
public class HelloService {
    public String sayHello() {
        return "Hello from HelloService!";
    }
}
