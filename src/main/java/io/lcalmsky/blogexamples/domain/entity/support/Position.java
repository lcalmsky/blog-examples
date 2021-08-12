package io.lcalmsky.blogexamples.domain.entity.support;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Position {
    GK("Goal Keeper"),
    CB("Center Back"),
    SW("Sweeper"),
    LB("Left Back"),
    RB("Right Back"),
    LWB("Left Wing Back"),
    RWB("Right Wing Back"),
    CM("Center Midfielder"),
    DM("Defensive Midfielder"),
    AM("Attacking Midfielder"),
    LM("Left Midfielder"),
    RM("Right Midfielder"),
    LW("Left Wing"),
    RW("Right Wing"),
    CF("Center Forward"),
    SS("Shadow Striker"),
    LWF("Left Wing Forward"),
    RWF("Right Wing Forward");

    @Getter
    @JsonValue
    private final String fullForm;

    private static final Map<String, Position> FULLFORM_MAP = Stream.of(values())
            .collect(Collectors.toMap(Position::getFullForm, Function.identity()));

    public static Position resolve(String fullForm) {
        return Optional.ofNullable(FULLFORM_MAP.get(fullForm))
                .orElseThrow(() -> new IllegalArgumentException("invalid full form"));
    }

    Position(String fullForm) {
        this.fullForm = fullForm;
    }
}