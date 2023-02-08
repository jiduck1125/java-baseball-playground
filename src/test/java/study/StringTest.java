package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] split1 = "1,2".split(",");
        assertThat(split1).contains("1", "2");

        String[] split2 = "1".split(",");
        assertThat(split2).containsExactly("1");
    }

    @Test
    void substring() {
        String given = "(1,2)";
        String substring = given.substring(given.indexOf("(") + 1, given.indexOf(")"));
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 특정 위치 문자 가져오기 테스트")
    void charAt() {
        String given = "abc";
        assertThat(given.charAt(2)).isEqualTo('c');
        assertThatThrownBy(() -> given.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

}
