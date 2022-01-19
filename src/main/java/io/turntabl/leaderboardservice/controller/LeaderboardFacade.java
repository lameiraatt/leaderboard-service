package io.turntabl.leaderboardservice.controller;

import io.turntabl.leaderboardservice.client.CodewarsClient;
import io.turntabl.leaderboardservice.client.response.UserDto;
import io.turntabl.leaderboardservice.controller.response.ProfileDto;
import io.turntabl.leaderboardservice.converter.ProfileToProfileDtoConverter;
import io.turntabl.leaderboardservice.converter.UserDtoToProfileConverter;
import io.turntabl.leaderboardservice.exceptions.ProfileAlreadyExistsException;
import io.turntabl.leaderboardservice.exceptions.UserDoesNotExistsException;
import io.turntabl.leaderboardservice.model.Profile;
import io.turntabl.leaderboardservice.service.LeaderboardRepositoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Slf4j
@Component
public class LeaderboardFacade {

    private final LeaderboardRepositoryService leaderboardRepositoryService;
    private final ProfileToProfileDtoConverter profileToProfileDtoConverter;
    private final UserDtoToProfileConverter userDtoToProfileConverter;
    private final CodewarsClient codewarsClient;

    public List<ProfileDto> getLeaderboard() {
        return leaderboardRepositoryService.getProfiles().stream()
                .map(profileToProfileDtoConverter::convert)
                .collect(toList());
    }

    public List<ProfileDto> getLeaderboardByLanguage(String language){
        return leaderboardRepositoryService.getProfiles().stream()
                .filter(p -> p.getLanguageLevels().stream().anyMatch( l -> l.getName().equals(language)))
                .map(profileToProfileDtoConverter::convert)
                .collect(toList());
    }

    public ProfileDto getProfileById(String username){
       return profileToProfileDtoConverter.convert(leaderboardRepositoryService.getProfileById(username));
    }

    /**
     * Adds a user to the leaderboard
     * @param username of codewars user
     */
    public void addUserToLeaderboard(String username) {
        log.info("Log -> Get user from codeWars client by username: {}",username);

//       /// if (user == null) throw new UserDoesNotExistsException("Username does not Exist on Codewars!");
//
////        log.info("Log -> Check if User Exists in Db Already: {}",username);
////        if(getProfileById(username) != null) throw new ProfileAlreadyExistsException("This Profile Already Exists");
//

//
//        log.info("Log -> Add profile to Database {}", profile);
        leaderboardRepositoryService.addProfile(username);

    }
}
