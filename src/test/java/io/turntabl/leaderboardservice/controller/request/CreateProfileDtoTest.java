package io.turntabl.leaderboardservice.controller.request;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CreateProfileDtoTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void shouldNotViolateConstraintsWhenUsernameIsValid() {
        // given
        CreateProfileDto createProfileDto = CreateProfileDto.builder()
                .username("banana")
                .build();

        // when
        Set<ConstraintViolation<CreateProfileDto>> result = validator.validate(createProfileDto);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    void shouldBeInvalidWhenUsernameIsNull() {
        // given
        CreateProfileDto createProfileDto = CreateProfileDto.builder().build();

        // when
        Set<ConstraintViolation<CreateProfileDto>> result = validator.validate(createProfileDto);

        // then
        assertThat(result)
                .extracting("message")
                .containsOnly("must not be blank");
    }

    @Test
    void shouldBeInvalidWhenUsernameIsEmpty() {
        // given
        CreateProfileDto createProfileDto = CreateProfileDto.builder()
                .username("")
                .build();

        // when
        Set<ConstraintViolation<CreateProfileDto>> result = validator.validate(createProfileDto);

        // then
        assertThat(result)
                .extracting("message")
                .containsOnly("must not be blank");
    }

    @Test
    void shouldBeInvalidWhenUsernameIsBlank() {
        // given
        CreateProfileDto createProfileDto = CreateProfileDto.builder()
                .username("   ")
                .build();

        // when
        Set<ConstraintViolation<CreateProfileDto>> result = validator.validate(createProfileDto);

        // then
        assertThat(result)
                .extracting("message")
                .containsOnly("must not be blank");
    }

}
