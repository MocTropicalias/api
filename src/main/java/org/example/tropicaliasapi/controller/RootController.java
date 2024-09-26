package org.example.tropicaliasapi.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Tag(name = "Root")
@RestController
@RequestMapping("/")
public class RootController {

    @GetMapping
    private void root(HttpServletResponse httpServletResponse){
        httpServletResponse.setHeader("Location", "/docs");
        httpServletResponse.setStatus(302);
    }

    @GetMapping("/healthcheck")
    private ResponseEntity<Map<String,String>> healthcheck() {
        return new ResponseEntity<>(Map.of("status", "healthy"),HttpStatus.OK);
    }

}
