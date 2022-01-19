package io.turntabl.leaderboardservice.controller;

import io.turntabl.leaderboardservice.client.CodewarsClient;
import io.turntabl.leaderboardservice.controller.response.ProfileDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/codewars")
@Slf4j
public class CodeWarsController {

    private final CodewarsClient codewarsClient;

    /**
     * Wrapper around codewars API for getting user
     * @param username string username of codewars user
     * @return UserDto of retrieved user
     */
    @GetMapping("{username}")
    public ResponseEntity<Object> getUser(@PathVariable String username) {
        log.info("log -> API to get Codewars User");
        return ResponseEntity.ok().body(codewarsClient.getUser(username));
    }

}
