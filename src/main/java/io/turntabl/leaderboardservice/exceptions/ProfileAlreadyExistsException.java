package io.turntabl.leaderboardservice.exceptions;

public class ProfileAlreadyExistsException extends RuntimeException{
    public ProfileAlreadyExistsException(String message) {
        super(message);
    }
}
