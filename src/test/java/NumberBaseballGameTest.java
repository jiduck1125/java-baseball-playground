import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberBaseballGameTest {

    @Test
    void initTargetNumber() {
        NumberBaseballGame game = new NumberBaseballGame();
        assertThat(game.getTargetNumber()).isNull();
        game.initTargetNumber();
        assertThat(game.getTargetNumber().length()).isEqualTo(game.getNumberLength());
    }
}