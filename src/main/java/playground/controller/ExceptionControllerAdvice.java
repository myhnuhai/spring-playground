package playground.controller;

import org.apache.shiro.ShiroException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @ResponseStatus(HttpStatus.UNAUTHORIZED) // 401
    @ExceptionHandler(ShiroException.class)
    public void handleShiroException(ShiroException ex) {
        LOGGER.debug(ex.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    public void handleAll(Throwable throwable) {
        LOGGER.error(throwable.getMessage(), throwable);
    }

}
