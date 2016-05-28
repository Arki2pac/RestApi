package pl.apilia.library.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by infokomes on 24.05.16.
 */

@ControllerAdvice
public class Exceptions {

    @ExceptionHandler({UserException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleNotFoundException(UserException exception){
        return exception.getMessage() + "<br><br>"
                + exception.getUserMessage();
    }
}
