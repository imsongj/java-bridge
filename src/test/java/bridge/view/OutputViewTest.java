package bridge.view;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.BridgePosition;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OutputViewTest {
    @ParameterizedTest
    @MethodSource("provideParametersForMap")
    @DisplayName("금액에 맞는 코인 개수를 반환한다.")
    void getNumberOfCoins(BridgePosition bridgePosition, boolean isCorrect, String result) {
        List<String> symbols = List.of("D","D","U","D");
        assertThat(new OutputView().convertSymbolsToString(symbols, bridgePosition, isCorrect))
                .isEqualTo(result);
    }

    private static Stream<Arguments> provideParametersForMap() {
        return Stream.of(
                Arguments.of(BridgePosition.DOWN, false, "O | O |   |  "),
                Arguments.of(BridgePosition.DOWN, true, "O | O |   | O"),
                Arguments.of(BridgePosition.UP, false, "  |   | O | X"),
                Arguments.of(BridgePosition.UP, true, "  |   | O |  ")
        );
    }
}
