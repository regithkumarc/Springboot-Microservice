package com.cprm.userservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DemoTestCasesTests {

    Calculator calculator = new Calculator();
    @Test
    void addNum(){
        int result = calculator.add(20,30);

        assertThat(result).isEqualTo(50);
    }

    class Calculator {
        int add(int a,int b){
            return a+b;
        }
    }
}
