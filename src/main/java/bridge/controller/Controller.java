package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.constant.GameCommand;
import bridge.model.validator.BridgeSizeValidator;
import bridge.model.validator.GameCommandValidator;
import bridge.model.validator.NextMoveValidator;
import bridge.model.validator.Validator;
import bridge.view.constant.ErrorMessage;
import bridge.view.constant.GameMessage;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        BridgeGame bridgeGame = createNewGame();
        runGame(bridgeGame);
        endGame(bridgeGame);
    }

    public void runGame(BridgeGame bridgeGame) {
        do {
            do {
                bridgeGame.move(getNextMove());
                outputView.printMap(bridgeGame);
            } while (bridgeGame.canPlayerTakeNextStep());
        } while (retry(bridgeGame));
    }

    public void endGame(BridgeGame bridgeGame) {
        outputView.printGameMessage(GameMessage.GAME_RESULT_HEADER);
        outputView.printMap(bridgeGame);
        outputView.printResult(bridgeGame);
    }

    public BridgeGame createNewGame() {
        int bridgeSize = getBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.initializeGame(bridge);
        return bridgeGame;
    }

    public boolean retry(BridgeGame bridgeGame) {
        if (bridgeGame.hasPlayerReachedEnd() || getGameCommand().equals(GameCommand.QUIT.getValue())) {
            return false;
        }
        bridgeGame.retry();
        return true;
    }

    public int getBridgeSize() {
        String input;
        do {
            outputView.printGameMessage(GameMessage.ASK_BRIDGE_SIZE);
            input = inputView.readBridgeSize();
        } while (!validateInput(input, new BridgeSizeValidator(), ErrorMessage.INVALID_BRIDGE_SIZE));
        return Integer.parseInt(input);
    }

    public String getNextMove() {
        String input;
        do {
            outputView.printGameMessage(GameMessage.ASK_NEXT_MOVE);
            input = inputView.readMoving();
        } while (!validateInput(input, new NextMoveValidator(), ErrorMessage.INVALID_NEXT_MOVE));
        return input;
    }

    public String getGameCommand() {
        String input;
        do {
            outputView.printGameMessage(GameMessage.ASK_RETRY);
            input = inputView.readGameCommand();
        } while (!validateInput(input, new GameCommandValidator(), ErrorMessage.INVALID_GAME_COMMAND));
        return input;
    }
    
    public boolean validateInput(String input, Validator inputValidator, ErrorMessage errorMessage) {
        try {
            inputValidator.validateInput(input);
            return true;
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(errorMessage);
            exception.printStackTrace();
            return false;
        }
    }
}
