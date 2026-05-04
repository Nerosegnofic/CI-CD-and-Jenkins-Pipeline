package com.calculator;

import org.example.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Unit Tests")
public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    // ─── Addition ────────────────────────────────────────────────────────────

    @Test
    @DisplayName("Add two positive numbers")
    void testAddPositive() {
        assertEquals(10.0, calculator.add(3, 7), "3 + 7 should equal 10");
    }

    @Test
    @DisplayName("Add a positive and a negative number")
    void testAddNegative() {
        assertEquals(-2.0, calculator.add(3, -5), "3 + (-5) should equal -2");
    }

    @Test
    @DisplayName("Add two decimal numbers")
    void testAddDecimals() {
        assertEquals(0.3, calculator.add(0.1, 0.2), 1e-9);
    }

    // ─── Subtraction ─────────────────────────────────────────────────────────

    @Test
    @DisplayName("Subtract two positive numbers")
    void testSubtractPositive() {
        assertEquals(5.0, calculator.subtract(10, 5), "10 - 5 should equal 5");
    }

    @Test
    @DisplayName("Subtract resulting in a negative number")
    void testSubtractNegativeResult() {
        assertEquals(-3.0, calculator.subtract(2, 5), "2 - 5 should equal -3");
    }

    // ─── Multiplication ──────────────────────────────────────────────────────

    @Test
    @DisplayName("Multiply two positive numbers")
    void testMultiplyPositive() {
        assertEquals(20.0, calculator.multiply(4, 5), "4 * 5 should equal 20");
    }

    @Test
    @DisplayName("Multiply by zero")
    void testMultiplyByZero() {
        assertEquals(0.0, calculator.multiply(9999, 0), "Any number * 0 should equal 0");
    }

    @Test
    @DisplayName("Multiply two negative numbers")
    void testMultiplyTwoNegatives() {
        assertEquals(15.0, calculator.multiply(-3, -5), "(-3) * (-5) should equal 15");
    }

    // ─── Division ────────────────────────────────────────────────────────────

    @Test
    @DisplayName("Divide two positive numbers")
    void testDividePositive() {
        assertEquals(4.0, calculator.divide(20, 5), "20 / 5 should equal 4");
    }

    @Test
    @DisplayName("Divide by zero throws ArithmeticException")
    void testDivideByZero() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(10, 0),
                "Dividing by zero should throw ArithmeticException"
        );
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }

    @Test
    @DisplayName("Divide resulting in a decimal")
    void testDivideDecimalResult() {
        assertEquals(2.5, calculator.divide(5, 2), "5 / 2 should equal 2.5");
    }

    // ─── Modulus ─────────────────────────────────────────────────────────────

    @Test
    @DisplayName("Modulus of two numbers")
    void testModulus() {
        assertEquals(1.0, calculator.modulus(10, 3), "10 % 3 should equal 1");
    }

    @Test
    @DisplayName("Modulus by zero throws ArithmeticException")
    void testModulusByZero() {
        assertThrows(
                ArithmeticException.class,
                () -> calculator.modulus(5, 0),
                "Modulus by zero should throw ArithmeticException"
        );
    }

    // ─── Power ───────────────────────────────────────────────────────────────

    @Test
    @DisplayName("Power of a number")
    void testPower() {
        assertEquals(8.0, calculator.power(2, 3), "2^3 should equal 8");
    }

    @Test
    @DisplayName("Power with exponent zero")
    void testPowerZeroExponent() {
        assertEquals(1.0, calculator.power(100, 0), "Any number ^ 0 should equal 1");
    }

    @Test
    @DisplayName("Power with negative exponent")
    void testPowerNegativeExponent() {
        assertEquals(0.25, calculator.power(2, -2), 1e-9);
    }

    // ─── Square Root ─────────────────────────────────────────────────────────

    @Test
    @DisplayName("Square root of a positive number")
    void testSqrtPositive() {
        assertEquals(4.0, calculator.sqrt(16), "sqrt(16) should equal 4");
    }

    @Test
    @DisplayName("Square root of zero")
    void testSqrtZero() {
        assertEquals(0.0, calculator.sqrt(0), "sqrt(0) should equal 0");
    }

    @Test
    @DisplayName("Square root of a negative number throws ArithmeticException")
    void testSqrtNegative() {
        assertThrows(
                ArithmeticException.class,
                () -> calculator.sqrt(-9),
                "sqrt of a negative number should throw ArithmeticException"
        );
    }
}