package bridge.domain;

import bridge.message.ErrorMessage;

public class Move {
    private static final String UP = "U";
    private static final String DOWN = "D";

    private final String symbol;

    public Move(String input) {
        validateMove(input);
        this.symbol = input;
    }

    public void validateMove(String input) {
        if (!input.equals(UP) && !input.equals(DOWN)) {
            throw new IllegalArgumentException(ErrorMessage.MOVE_EXCEPTION);
        }
    }
}
