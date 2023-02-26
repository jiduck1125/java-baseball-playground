package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallTest {

    private Ball comBall;

    @BeforeEach
    void initialize() {
        comBall = new Ball(1, 4);
    }

    @Test
    void match_Ball_Strike() {
        assertThat(comBall.match(new Ball(1, 4))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void match_Ball_Ball() {
        assertThat(comBall.match(new Ball(2, 4))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void match_Ball_Nothing() {
        assertThat(comBall.match(new Ball(2, 7))).isEqualTo(BallStatus.NOTHING);
    }

}
