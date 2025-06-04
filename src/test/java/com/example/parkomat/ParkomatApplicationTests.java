package com.example.parkomat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootTest
public class ParkomatApplicationTests {

    @GetMapping("/api/test")
    public String test() {
        return "Wszystko dziala";
    }

}
