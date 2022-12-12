package bridge.domain;

import java.util.Collections;
import java.util.List;

public class Bridge {
    private final List<String> symbols;

    public Bridge(List<String> bridgeSymbols) {
        this.symbols = bridgeSymbols;
    }

    public int size() {
        return symbols.size();
    }

    public List<String> getSymbols(int end) {
        return Collections.unmodifiableList(symbols.subList(0, end));
    }

    public boolean isCorrectMove(int index, List<Move> moves) {
        return moves.get(index).equals(symbols.get(index));
    }

}
