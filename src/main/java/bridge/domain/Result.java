package bridge.domain;

import java.util.List;

public class Result {
    private final List<String> symbols;
    private final boolean lastMove;
    private final boolean reachedEnd;


    public Result(Bridge bridge, List<Move> moves) {
        this.symbols = bridge.getSymbols(moves.size());
        this.lastMove = bridge.isCorrectMove(moves.size() - 1, moves);
        this.reachedEnd = bridge.size() == moves.size();
    }

    public List<String> getSymbols() {
        return symbols;
    }

    public boolean isLastMoveCorrect() {
        return lastMove;
    }

    public boolean hasReachedEnd() {
        return reachedEnd;
    }
}
