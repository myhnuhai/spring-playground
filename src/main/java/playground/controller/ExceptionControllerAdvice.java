package playground.controller;

import org.apache.shiro.ShiroException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @ExceptionHandler(ShiroException.class)
    public void handleShiroException(ShiroException ex) {
        LOGGER.debug(ex.getMessage(), ex);
    }

    @ExceptionHandler(Throwable.class)
    public void handleAll(Throwable throwable) {
        LOGGER.error(throwable.getMessage(), throwable);
    }

}
