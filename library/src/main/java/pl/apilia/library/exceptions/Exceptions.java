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

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleNotFoundException(NotFoundException exception){
        return "STATUS 404 NOT FOUND <br><br>"
                + exception.getUserMessage();
    }

    @ExceptionHandler({BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleBadRequestException(BadRequestException exception){
        return "STATUS 400 BAD REQUEST <br><br>"
                + exception.getUserMessage();
    }

    @ExceptionHandler({ConflictException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public String handleConflictException(ConflictException exception){
        return "STATUS 409 CONFLICT <br><br>"
                + exception.getUserMessage();
    }
}
