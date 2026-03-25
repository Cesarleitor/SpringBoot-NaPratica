package br.com.cesar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourseNotFoudException extends RuntimeException {

    public ResourseNotFoudException(String message) {

        super(message);
    }
}
