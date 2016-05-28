package pl.apilia.library.exceptions;

/**
 * Created by Grzegorz on 2016-05-28.
 */
public class BadRequestException extends Exception {

    private String userMessage;

    public BadRequestException(String userMessage) {
        super();
        this.userMessage = userMessage;
    }

    public String getUserMessage() {
        return userMessage;
    }

}
