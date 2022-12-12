package bridge.domain;

import java.util.List;

public class BridgeMap {
    private final List<String> symbols;
    private final boolean lastMove;

    public BridgeMap(Bridge bridge, List<Move> moves) {
        symbols = bridge.getSymbols(moves.size());
        lastMove = bridge.isCorrectMove(moves.size() - 1, moves);
    }

    public List<String> getSymbols() {
        return symbols;
    }

    public boolean isLastMoveCorrect() {
        return lastMove;
    }
}
