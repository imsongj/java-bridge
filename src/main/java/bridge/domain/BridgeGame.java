package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private final List<Move> moves;
    private int attempts;

    public BridgeGame() {
        moves = new ArrayList<>();
        attempts = 0;
    }

    public void initializeBridge(List<String> bridgeSymbols) {
        this.bridge = new Bridge(bridgeSymbols);
    }

    public void resetMoves() {
        moves.clear();
    }

    public void incrementAttempts() {
        attempts++;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Move move) {
        moves.add(move);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        incrementAttempts();
        resetMoves();
    }

    public BridgeMap getBridgeMap() {
        return new BridgeMap(bridge, moves);
    }

    public boolean canMove() {
        BridgeMap result = new BridgeMap(bridge, moves);
        return !result.hasReachedEnd() && result.isLastMoveCorrect();
    }

    public boolean hasReachedEnd() {
        BridgeMap bridgeMap = new BridgeMap(bridge, moves);
        return bridgeMap.hasReachedEnd() && bridgeMap.isLastMoveCorrect();
    }

    public Result getResult() {
        return new Result(new BridgeMap(bridge, moves).isLastMoveCorrect(), attempts);
    }
}
