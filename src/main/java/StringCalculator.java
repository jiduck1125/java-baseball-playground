import java.util.Arrays;

public class StringCalculator {

    private static final String[] operators = {"+", "-", "*", "/"};

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        return a / b;
    }

    public static boolean isOperator(String value) {
        return Arrays.stream(operators).anyMatch(value::equals);
    }

    public static int calculate(int a, int b, String operator) {
        int result;
        switch (operator) {
            case "+":
                result = add(a, b);
                break;
            case "-":
                result = subtract(a, b);
                break;
            case "*":
                result = multiply(a, b);
                break;
            case "/":
                result = divide(a, b);
                break;
            default:
                result = a;
                break;
        }
        return result;
    }

    public static int calculate(String input) {
        String[] inputs = input.split(" ");

        int result = Integer.valueOf(inputs[0]);
        String operator = "";

        for (int i = 1; i < inputs.length; i++) {
            if (isOperator(inputs[i])) {
                operator = inputs[i];
                continue;
            }
            int number = Integer.valueOf(inputs[i]);
            result = calculate(result, number, operator);
        }

        return result;
    }


}
