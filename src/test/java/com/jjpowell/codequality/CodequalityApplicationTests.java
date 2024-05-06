package com.jjpowell.codequality;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CodequalityApplicationTests {

    @Test
    void contextLoads() {
        String a = "hello";
        String b = "hello";
        System.out.println(a == b);
    }
}
