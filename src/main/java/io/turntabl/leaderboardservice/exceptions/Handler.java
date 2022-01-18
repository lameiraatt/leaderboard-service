package io.turntabl.leaderboardservice.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@ControllerAdvice
public class Handler {

    private static final String SERVER_ERROR = "Server Error: ";

    @ExceptionHandler({ Exception.class, UserDoesNotExistsException.class, javax.servlet.ServletException.class})
    public ResponseEntity<Object> handle(Exception ex,
                                         HttpServletRequest request, HttpServletResponse response) {
        if (ex instanceof NullPointerException) return new ResponseEntity<>(SERVER_ERROR+ex.getMessage(), HttpStatus.BAD_REQUEST);

        else if (ex instanceof UserDoesNotExistsException) return new ResponseEntity<>(SERVER_ERROR+ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);


    }
}