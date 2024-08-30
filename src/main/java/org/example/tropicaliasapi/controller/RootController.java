package org.example.tropicaliasapi.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Root")
@RestController
@RequestMapping("/")
public class RootController {

    @GetMapping
    private String root() {
        return "Hello World";
    }

}
