package bridge.domain;

import bridge.message.ErrorMessage;

import java.util.regex.Pattern;

public class BridgeSize {
    private static final String NUMERIC_PATTERN = "^[0-9]*$";
    private static final int MINIMUM = 3;
    private static final int MAXIMUM = 20;

    private final int size;

    public BridgeSize(String sizeInput) {
        validateNumeric(sizeInput);
        validateInteger(sizeInput);
        this.size = Integer.parseInt(sizeInput);
        validateRange(size);
    }

    public int getSize() {
        return size;
    }

    public void validateNumeric(String input) {
        if (input == null || !Pattern.matches(NUMERIC_PATTERN, input)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_EXCEPTION);
        }
    }

    public void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_EXCEPTION);
        }
    }

    public void validateRange(int size) {
        if (size < MINIMUM || size > MAXIMUM) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_EXCEPTION);
        }
    }
}
