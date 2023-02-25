package baseball;

import java.util.HashSet;
import java.util.List;

public class ValidationUtils {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int NUMBER_LENGTH = 3;

    public static boolean isValidNumber(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    public static boolean isValidLength(List<Integer> numbers) {
        return numbers.size() == NUMBER_LENGTH;
    }

    public static boolean hasNoDuplication(List<Integer> numbers) {
        return new HashSet<>(numbers).size() == numbers.size();
    }
}
