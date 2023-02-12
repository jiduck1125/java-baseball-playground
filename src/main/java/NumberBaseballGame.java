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
}
