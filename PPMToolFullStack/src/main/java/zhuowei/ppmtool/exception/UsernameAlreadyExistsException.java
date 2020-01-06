package zhuowei.ppmtool.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class UsernameAlreadyExistsException extends RuntimeException{
    public UsernameAlreadyExistsException(String message) {
        super(message);
    }
}
