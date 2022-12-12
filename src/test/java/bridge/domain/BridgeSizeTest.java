package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BridgeSizeTest {
    @ParameterizedTest
    @CsvSource({
            "23",
            "2",
            "asdf23"
    })
    @DisplayName("잘못된 다리 길이를 입력받으면 예외를 발생시킨다.")
    void throwExceptionForInvalidInputSize(String sizeInput) {
        assertThatThrownBy(() -> new BridgeSize(sizeInput)).isInstanceOf(IllegalArgumentException.class);
    }
}
