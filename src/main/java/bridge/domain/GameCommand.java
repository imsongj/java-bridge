package bridge.domain;

import bridge.message.ErrorMessage;

public class GameCommand {
    private static final String RETRY = "R";
    private static final String QUIT = "Q";

    private final String symbol;

    public GameCommand(String input) {
        validateMove(input);
        this.symbol = input;
    }

    public void validateMove(String input) {
        if (!input.equals(RETRY) && !input.equals(QUIT)) {
            throw new IllegalArgumentException(ErrorMessage.GAME_COMMAND_EXCEPTION);
        }
    }

    public boolean retry() {
        return this.symbol.equals(RETRY);
    }
}
