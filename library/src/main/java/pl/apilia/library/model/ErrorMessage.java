package pl.apilia.library.model;

/**
 * Created by infokomes on 24.05.16.
 */
public class ErrorMessage {
    private String message;
    private String userMessage;

    public ErrorMessage(String message, String userMessage) {
        this.message = message;
        this.userMessage = userMessage;
    }

    public String getMessage() {
        return message;
    }

    public String getUserMessage() {
        return userMessage;
    }
}
