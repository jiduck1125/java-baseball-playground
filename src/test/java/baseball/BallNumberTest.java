package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class BallNumberTest {

    @Test
    void validation_NumberRange() {
        assertThat(new BallNumber(1)).isInstanceOf(BallNumber.class);
        assertThat(new BallNumber(9)).isInstanceOf(BallNumber.class);
        assertThatThrownBy(() -> new BallNumber(0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("볼 숫자의 범위는");
        assertThatThrownBy(() -> new BallNumber(10))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("볼 숫자의 범위는");
    }

}