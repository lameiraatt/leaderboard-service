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

    @GetMapping("profile/{username}")
    public ProfileDto getProfileById(@PathVariable String username){
        return leaderboardFacade.getProfileById(username);
    }

    @GetMapping("/{language}")
    public List<ProfileDto> getLeaderboardByLanguage(@PathVariable String language){
        return leaderboardFacade.getLeaderboardByLanguage(language);
    }

    /**
     * API to add codewars user to the leaderboard
     * @param body containing username of codewars user
     * @return success if successful
     */
    @PostMapping
    public ResponseEntity<Object> addUserToLeaderBoard(@RequestBody AddUserToLeaderboardBody body ) {
        leaderboardFacade.addUserToLeaderboard(body.getUsername());
        return ResponseEntity.ok().body("User Successfully Added");
    }
    @Data
    static class AddUserToLeaderboardBody {
        @NotNull
        private String username;
    }

}
