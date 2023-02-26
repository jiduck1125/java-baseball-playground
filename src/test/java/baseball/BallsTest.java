package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallsTest {

    private Balls comBalls;

    @BeforeEach
    void initialize() {
        comBalls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void match_BallsAndBall_Strike() {
        BallStatus ballStatus = comBalls.match(new Ball(1, 1));
        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void match_BallsAndBall_Ball() {
        BallStatus ballStatus = comBalls.match(new Ball(3, 2));
        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    void match_BallsAndBall_Nothing() {
        BallStatus ballStatus = comBalls.match(new Ball(3, 8));
        assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void match_Balls_3Strike() {
        MatchResult result = comBalls.match(Arrays.asList(1, 2, 3));
        assertThat(result.getStrikeCount()).isEqualTo(3);
        assertThat(result.getBallCount()).isEqualTo(0);
    }

    @Test
    void match_Balls_1Strike2Ball() {
        MatchResult result = comBalls.match(Arrays.asList(1, 3, 2));
        assertThat(result.getStrikeCount()).isEqualTo(1);
        assertThat(result.getBallCount()).isEqualTo(2);
    }

    @Test
    void match_Balls_Nothing() {
        MatchResult result = comBalls.match(Arrays.asList(5, 6, 7));
        assertThat(result.getStrikeCount()).isEqualTo(0);
        assertThat(result.getBallCount()).isEqualTo(0);
    }


}
