package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeSize;
import bridge.domain.GameCommand;
import bridge.domain.Move;
import bridge.message.GameMessage;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        BridgeGame bridgeGame = new BridgeGame();
        outputView.printMessage(GameMessage.START);
        initialize(bridgeGame);
        run(bridgeGame);
    }

    public void initialize(BridgeGame bridgeGame) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame.initializeBridge(bridgeMaker.makeBridge(getBridgeSize().getSize()));
    }

    public void run(BridgeGame bridgeGame) {
        do {
            makeMoves(bridgeGame);
        } while (!bridgeGame.hasReachedEnd() && getGameCommand().retry());
    }

    public void makeMoves(BridgeGame bridgeGame) {
        do {
            bridgeGame.move(getNextMove());
            outputView.printMap(bridgeGame.getResult());
        } while (bridgeGame.canMove());
    }

    public BridgeSize getBridgeSize() {
        try {
            return new BridgeSize(inputView.readBridgeSize());
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception);
            return getBridgeSize();
        }
    }

    public Move getNextMove() {
        try {
            return new Move(inputView.readMoving());
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception);
            return getNextMove();
        }
    }

    public GameCommand getGameCommand() {
        try {
            return new GameCommand(inputView.readGameCommand());
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception);
            return getGameCommand();
        }
    }
}
