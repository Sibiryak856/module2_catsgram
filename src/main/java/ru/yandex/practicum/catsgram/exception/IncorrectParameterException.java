package ru.yandex.practicum.catsgram.exception;

public class IncorrectParameterException extends RuntimeException {


    public IncorrectParameterException() {
    }

    public IncorrectParameterException(String message) {
        super(message);
    }

    public IncorrectParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectParameterException(Throwable cause) {
        super(cause);
    }

    public IncorrectParameterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
