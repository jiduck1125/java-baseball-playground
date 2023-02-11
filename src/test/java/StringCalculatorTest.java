import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource({"1,1,2", "2,3,5", "0,3,3", "1,-1,0"})
    void add(int a, int b, int expected) {
        assertEquals(expected, StringCalculator.add(a, b));
    }

    @ParameterizedTest
    @CsvSource({"1,1,0", "2,3,-1", "0,3,-3", "1,-1,2"})
    void subtract(int a, int b, int expected) {
        assertEquals(expected, StringCalculator.subtract(a, b));
    }

    @ParameterizedTest
    @CsvSource({"1,1,1", "2,3,6", "0,3,0", "1,-1,-1"})
    void multiply(int a, int b, int expected) {
        assertEquals(expected, StringCalculator.multiply(a, b));
    }

    @ParameterizedTest
    @CsvSource({"1,1,1", "2,3,0", "0,3,0", "1,-1,-1", "4,2,2",})
    void divide(int a, int b, int expected) {
        assertEquals(expected, StringCalculator.divide(a, b));
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void isOperator_true(String input) {
        assertTrue(StringCalculator.isOperator(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", " ", "", "&"})
    void isOperator_false(String input) {
        assertFalse(StringCalculator.isOperator(input));
    }

    @ParameterizedTest
    @CsvSource({"2,3,+,5", "2,3,-,-1", "2,5,*,10", "10,2,/,5"})
    void calculate_int(int a, int b, String operator, int expected) {
        assertEquals(expected, StringCalculator.calculate(a, b, operator));
    }

    @ParameterizedTest
    @CsvSource({"2 + 3 * 4 / 2, 10", "60 * 60 * 24 / 24 / 60, 60", "7 - 2 * 4, 20"})
    void calculate_string(String input, int expected) {
        assertEquals(expected, StringCalculator.calculate(input));
    }
}