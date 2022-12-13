package bridge.domain;

import java.util.Arrays;

public enum BridgePosition {
    UP(1, "U"),
    DOWN(0, "D");

    private final int number;
    private final String symbol;

    BridgePosition(int number, String symbol) {
        this.number = number;
        this.symbol = symbol;
    }

    public boolean equals(String symbol) {
        return this.symbol.equals(symbol);
    }

    public static String getSymbolOf(int number) {
        return Arrays.stream(BridgePosition.values())
                .filter(bridgePosition -> bridgePosition.equals(number))
                .findFirst()
                .map(BridgePosition::getSymbol)
                .orElseThrow(IllegalArgumentException::new);
    }

    public boolean equals(int number) {
        return this.number == number;
    }

    public String getSymbol() {
        return symbol;
    }
}
