package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoveTest {
    @ParameterizedTest
    @CsvSource({
            "23",
            "Z",
            "u"
    })
    @DisplayName("잘못된 이동할 칸 입력를 입력받으면 예외를 발생시킨다.")
    void throwExceptionForInvalidInputSize(String input) {
        assertThatThrownBy(() -> new Move(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
