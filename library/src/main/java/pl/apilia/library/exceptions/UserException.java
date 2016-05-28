package pl.apilia.library.exceptions;



import pl.apilia.library.model.ErrorMessage;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;


public class UserException extends Exception {

    private String message;
    private String userMessage;

    public UserException(String message, String userMessage) {
        super();
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
