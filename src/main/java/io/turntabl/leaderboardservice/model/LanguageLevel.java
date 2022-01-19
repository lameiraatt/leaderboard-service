package io.turntabl.leaderboardservice.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LANGUAGE_LEVELS")
@Data
@Accessors(chain = true)
@IdClass(LanguageLevelId.class)
public class LanguageLevel {

    @Id
    private Integer rank;

    private String name;

    @Id
    @ManyToOne
    @JoinColumn(name="PROFILE_ID", nullable=false)
    @ToString.Exclude
    private Profile profile;
}
