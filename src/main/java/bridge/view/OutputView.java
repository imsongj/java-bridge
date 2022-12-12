package bridge.view;

import static bridge.domain.BridgePosition.UP;
import static bridge.domain.BridgePosition.DOWN;

import bridge.domain.BridgeMap;
import bridge.domain.BridgePosition;

import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String CORRECT= "O";
    private static final String INCORRECT = "X";
    private static final String UNKNOWN = " ";
    private static final String MAP_FORMAT = "[ %s ]%n";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeMap bridgeMap) {
        System.out.printf(MAP_FORMAT,
                convertSymbolsToString(bridgeMap.getSymbols(), UP, bridgeMap.isLastMoveCorrect()));
        System.out.printf(MAP_FORMAT,
                convertSymbolsToString(bridgeMap.getSymbols(), DOWN, bridgeMap.isLastMoveCorrect()));
    }

    public String convertSymbolsToString(List<String> symbols, BridgePosition bridgePosition, boolean isCorrect) {
        StringJoiner stringJoiner = new StringJoiner(" | ");
        for (int index = 0; index < symbols.size() - 1; index++) {
            stringJoiner.add(getMapSymbol(symbols.get(index), bridgePosition));
        }
        stringJoiner.add(getLastSymbol(symbols.get(symbols.size() - 1), bridgePosition, isCorrect));
        return stringJoiner.toString();
    }

    public String getMapSymbol(String symbol, BridgePosition bridgePosition) {
        if (bridgePosition.equals(symbol)) {
            return CORRECT;
        }
        return UNKNOWN;
    }

    public String getLastSymbol(String symbol, BridgePosition bridgePosition, boolean isCorrect) {
        if (bridgePosition.equals(symbol) && isCorrect) {
            return CORRECT;
        }
        if (bridgePosition.equals(symbol) && !isCorrect) {
            return INCORRECT;
        }
        return UNKNOWN;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
