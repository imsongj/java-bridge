package bridge.view;

import bridge.message.GameMessage;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final OutputView outputView;
    public InputView() {
        outputView = new OutputView();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        outputView.printMessage(GameMessage.ASK_BRIDGE_SIZE);
        return Console.readLine();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        outputView.printMessage(GameMessage.ASK_MOVE);
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
