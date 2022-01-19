package io.turntabl.leaderboardservice.exceptions;

public class UserDoesNotExistsException extends RuntimeException{
    public UserDoesNotExistsException(String message) {
        super(message);
    }
}
