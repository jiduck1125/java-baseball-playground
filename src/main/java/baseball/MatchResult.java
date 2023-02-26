package baseball;

public class MatchResult {


    private int strikeCount = 0;
    private int ballCount = 0;

    public int getStrikeCount() {
        return this.strikeCount;
    }

    public int getBallCount() {
        return this.ballCount;
    }

    public void report(BallStatus ballStatus) {
        if (ballStatus.isStrike()) {
            strikeCount++;
        }
        if (ballStatus.isBall()) {
            ballCount++;
        }
    }

    public boolean isGameEnd() {
        return strikeCount == ValidationUtils.NUMBER_LENGTH;
    }
}
