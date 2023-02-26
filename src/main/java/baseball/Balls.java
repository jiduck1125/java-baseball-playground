package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> balls;

    public Balls(List<Integer> numbers) {
        this.balls = mapBalls(numbers);
    }

    private static List<Ball> mapBalls(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            balls.add(new Ball(i + 1, numbers.get(i)));
        }
        return balls;
    }

    public BallStatus match(Ball compare) {
        return balls.stream()
            .map(ball -> ball.match(compare))
            .filter(BallStatus::isNotNothing)
            .findFirst()
            .orElse(BallStatus.NOTHING);
    }

    public MatchResult match(List<Integer> numbers) {
        Balls compareBalls = new Balls(numbers);
        MatchResult result = new MatchResult();

        for (Ball ball : balls) {
            result.report(compareBalls.match(ball));
        }
        return result;
    }
}
