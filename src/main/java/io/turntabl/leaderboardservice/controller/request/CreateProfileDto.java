package io.turntabl.leaderboardservice.controller.request;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotBlank;

@Value
@Builder
@Jacksonized
public class CreateProfileDto {

    @NotBlank
    String username;
}
