import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class NumberBaseballGameTest {

    @Test
    void initTargetNumbers() {
        NumberBaseballGame game = new NumberBaseballGame();
        assertThat(game.getTargetNumber()).isEqualTo(null);
        game.initTargetNumber();
        assertThat(game.getTargetNumber().length()).isEqualTo(game.getNumberLength());
    }

    @ParameterizedTest
    @CsvSource({"123,1,1", "374,1,0", "030,0,2", "713,7,1"})
    void getContainCount(String targetNumber, char compare, int expected) {
        NumberBaseballGame game = new NumberBaseballGame();
        assertThat(game.getContainCount(targetNumber, compare)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"123,1,0,1", "374,1,2,0", "030,0,0,1", "713,7,2,0"})
    void getStrikeCount(String targetNumber, char compare, int index, int expected) {
        NumberBaseballGame game = new NumberBaseballGame();
        assertThat(game.getStrikeCount(targetNumber, compare, index)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource
    void getMatchResult(String targetNumber, String compare, int[] expected) {
        NumberBaseballGame game = new NumberBaseballGame();
        int[] result = game.getMatchResult(targetNumber, compare);
        assertThat(result).containsExactly(expected);
    }

    static Stream<Arguments> getMatchResult() {
        return Stream.of(arguments("425", "123", new int[]{0, 1}),
            arguments("425", "456", new int[]{1, 1}), arguments("425", "789", new int[]{0, 0}),
            arguments("713", "123", new int[]{1, 1}), arguments("713", "145", new int[]{1, 0}),
            arguments("713", "671", new int[]{2, 0}), arguments("713", "216", new int[]{0, 1}),
            arguments("713", "713", new int[]{0, 3}));
    }


    @ParameterizedTest
    @CsvSource({"2,1,2볼 1스트라이크", "0,1,1스트라이크", "2,0,2볼", "0,0,낫싱"})
    void getMatchResultMessage(int ball, int strike, String expected) {
        NumberBaseballGame game = new NumberBaseballGame();
        assertThat(game.getMatchResultMessage(ball, strike)).isEqualTo(expected);
    }
}