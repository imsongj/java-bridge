package bridge.domain;

public enum BridgePosition {
    UP(1, "U"),
    DOWN(0, "D");

    private final int number;
    private final String symbol;

    BridgePosition(int number, String symbol) {
        this.number = number;
        this.symbol = symbol;
    }

    public static String getSymbolOf(int number) {
        for (BridgePosition bridgePosition : BridgePosition.values()) {
            if (bridgePosition.number == number) {
                return bridgePosition.symbol;
            }
        }
        throw new IllegalArgumentException();
    }
}
