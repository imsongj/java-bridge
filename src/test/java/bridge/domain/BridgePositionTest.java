package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BridgePositionTest {
    @ParameterizedTest
    @CsvSource({
            "1, U",
            "0, D",
    })
    @DisplayName("잘못된 다리 길이를 입력받으면 예외를 발생시킨다.")
    void throwExceptionForInvalidInputSize(int number, String symbol) {
        assertThat(BridgePosition.getSymbolOf(number)).isEqualTo(symbol);
    }
}
