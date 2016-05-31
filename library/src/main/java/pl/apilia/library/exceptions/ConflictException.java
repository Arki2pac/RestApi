package pl.apilia.library.exceptions;

/**
 * Created by infokomes on 31.05.16.
 */
public class ConflictException extends Exception {

    private String userMessage;

    public ConflictException(String userMessage) {
        super();
        this.userMessage = userMessage;
    }

    public String getUserMessage() {
        return userMessage;
    }

}
