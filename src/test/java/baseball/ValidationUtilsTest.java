package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ValidationUtilsTest {

    @Test
    void isValidNumber_Between1And9_True() {
        assertThat(ValidationUtils.isValidNumber(1)).isTrue();
        assertThat(ValidationUtils.isValidNumber(9)).isTrue();
        assertThat(ValidationUtils.isValidNumber(0)).isFalse();
        assertThat(ValidationUtils.isValidNumber(10)).isFalse();
    }

    @Test
    void isValidLength_LengthIs3_True() {
        assertThat(ValidationUtils.isValidLength(Arrays.asList(1, 2, 3))).isTrue();
        assertThat(ValidationUtils.isValidLength(Arrays.asList(1, 2))).isFalse();
        assertThat(ValidationUtils.isValidLength(Arrays.asList(1, 2, 3, 4))).isFalse();
    }

    @Test
    void hasNoDuplication_NoDuplication_True() {
        assertThat(ValidationUtils.hasNoDuplication(Arrays.asList(1, 2, 3))).isTrue();
        assertThat(ValidationUtils.hasNoDuplication(Arrays.asList(1, 2, 1))).isFalse();
        assertThat(ValidationUtils.hasNoDuplication(Arrays.asList(1))).isTrue();
    }

}