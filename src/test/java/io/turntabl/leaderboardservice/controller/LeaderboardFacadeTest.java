package io.turntabl.leaderboardservice.controller;

import io.turntabl.leaderboardservice.controller.response.ProfileDto;
import io.turntabl.leaderboardservice.converter.ProfileToProfileDtoConverter;
import io.turntabl.leaderboardservice.service.LeaderboardRepositoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
class LeaderboardFacadeTest {
    @MockBean
    private LeaderboardRepositoryService repositoryService;

    @MockBean
    private ProfileToProfileDtoConverter converter;

    @Test
    void shouldGetLeaderBoardFacadeTest() {
        ProfileDto profileDto = ProfileDto.builder()
                .username("lameiraatt")
                .name("Ana Lameira")
                .build();
        List<ProfileDto> resultList = List.of(profileDto);
        var dtoList = repositoryService.getProfiles().stream()
                .map(converter::convert).collect(toList());

        assertThat(String.valueOf(resultList.contains(dtoList)), true);
    }
}
