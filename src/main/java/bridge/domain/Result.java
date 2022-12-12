package bridge.domain;

public class Result {
    private final boolean isSuccess;
    private final int attempts;

    Result(boolean isSuccess, int attempts) {
        this.isSuccess = isSuccess;
        this.attempts = attempts;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getAttempts() {
        return attempts;
    }
}
