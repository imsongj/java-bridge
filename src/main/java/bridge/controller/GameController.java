package bridge.controller;

import bridge.domain.BridgeSize;
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
        outputView.printMessage(GameMessage.START);
        getBridgeSize();
    }

    public BridgeSize getBridgeSize() {
        try {
            return new BridgeSize(inputView.readBridgeSize());
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception);
            return getBridgeSize();
        }
    }
}
