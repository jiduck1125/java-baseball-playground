package baseball;

import java.util.Objects;

public class BallNumber {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    private int number;

    public BallNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(
                "볼 숫자의 범위는 " + MIN_NUMBER + "부터 " + MAX_NUMBER + "까지의 값이어야 합니다.");
        }
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
