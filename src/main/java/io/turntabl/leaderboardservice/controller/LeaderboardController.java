package io.turntabl.leaderboardservice.controller;

import com.sun.istack.NotNull;
import io.turntabl.leaderboardservice.controller.response.ProfileDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/leaderboard")
public class LeaderboardController {

    private final LeaderboardFacade leaderboardFacade;

    @GetMapping
    public List<ProfileDto> getLeaderboard() {
        return leaderboardFacade.getLeaderboard();
    }


    @PostMapping
    public ResponseEntity<Object> addUserToLeaderBoard(@RequestBody AddUserToLeaderboardBody body ) {
        leaderboardFacade.addUserToLeaderboard(body.getUsername());
        return ResponseEntity.ok().body("Success");
    }
    @Data
    static class AddUserToLeaderboardBody {
        @NotNull
        private String username;
    }

}
