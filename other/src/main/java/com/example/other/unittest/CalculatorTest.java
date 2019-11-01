package com.example.other.unittest;

import org.junit.Test;

public class CalculatorTest {
    @Test
    public void testAdd(){
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 2);
        assert result == 3;
    }

}
