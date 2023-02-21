import java.util.Scanner;
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

    public String getMatchResultMessage(int ball, int strike) {
        if (ball > 0 && strike > 0) {
            return ball + "볼 " + strike + "스트라이크";
        }
        if (ball > 0 && strike == 0) {
            return ball + "볼";
        }
        if (ball == 0 && strike > 0) {
            return strike + "스트라이크";
        }
        return "낫싱";
    }

    public boolean willPlay() {
        int flag = InputView.getGameProcessFlag();
        if (flag == 1) {
            return true;
        }
        ResultView.printExitMessage();
        return false;
    }

    public static class InputView {

        public static final Scanner scanner = new Scanner(System.in);

        public static String getInputNumber() {
            System.out.print("숫자를 입력해 주세요 : ");
            return scanner.next();
        }

        public static int getGameProcessFlag() {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return scanner.nextInt();
        }

    }

    public static class ResultView {

        public static void printMatchResultMessage(String message) {
            System.out.println(message);
        }

        public static void printFinishMessage(int numberLength) {
            System.out.println(numberLength + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

        public static void printExitMessage() {
            System.out.println("게임 종료");
        }
    }


}
