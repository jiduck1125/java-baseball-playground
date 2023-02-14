import java.util.concurrent.ThreadLocalRandom;

public class NumberBaseballGame {

    private static final int NUMBER_LENGTH = 3;

    private String targetNumber;

    public String getTargetNumber() {
        return targetNumber;
    }

    public int getNumberLength() {
        return NUMBER_LENGTH;
    }

    public void initTargetNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            sb.append(ThreadLocalRandom.current().nextInt(1, 9 + 1));
        }
        targetNumber = sb.toString();
    }

    public int[] getMatchResult(String targetNumber, String compare) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < targetNumber.length(); i++) {
            ball += getContainCount(targetNumber, compare.charAt(i));
            strike += getStrikeCount(targetNumber, compare.charAt(i), i);
        }
        ball -= strike;

        return new int[]{ball, strike};
    }

    public int getContainCount(String targetNumber, char compare) {
        return targetNumber.length()
            - targetNumber.replace(String.valueOf(compare), "").length();
    }

    public int getStrikeCount(String targetNumber, char compare, int index) {
        if (targetNumber.charAt(index) == compare) {
            return 1;
        }
        return 0;
    }


}
