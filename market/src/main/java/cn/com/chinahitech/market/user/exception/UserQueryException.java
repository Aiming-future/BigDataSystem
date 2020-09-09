package cn.com.chinahitech.market.user.exception;

public class UserQueryException extends Exception {

    public UserQueryException() {
        super();
    }

    public UserQueryException(String message) {
        super(message);
    }

    public UserQueryException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserQueryException(Throwable cause) {
        super(cause);
    }

    protected UserQueryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
