package io.turntabl.leaderboardservice.service;

import io.turntabl.leaderboardservice.model.Profile;
import io.turntabl.leaderboardservice.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LeaderboardRepositoryService {

    private final ProfileRepository profileRepository;

    public List<Profile> getProfiles() {
        return profileRepository.findAll();
    }


    public void addProfile(String username){
        // add logic to check user from codewars
        Profile profile = new Profile().setId(username);
        profileRepository.save(profile);

    }

    public Profile getProfileById(String username){
        return profileRepository.getById(username);
    }
}
