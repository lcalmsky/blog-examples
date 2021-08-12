package io.lcalmsky.blogexamples.domain.entity.support;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Gender {
    MALE("M"),
    FEMALE("F");

    private static final Map<String, Gender> CODE_MAP = Stream.of(values())
            .collect(Collectors.toMap(Gender::getValue, Function.identity()));

    public static Gender resolve(String code) {
        return Optional.ofNullable(CODE_MAP.get(code))
                .orElseThrow(() -> new IllegalArgumentException("invalid code"));
    }

    @Converter
    public static final class GenderConverter implements AttributeConverter<Gender, String> {
        @Override
        public String convertToDatabaseColumn(Gender attribute) {
            return attribute.getValue();
        }

        @Override
        public Gender convertToEntityAttribute(String dbData) {
            return Gender.resolve(dbData);
        }
    }

    @Getter
    @JsonValue
    private final String value;

    Gender(String value) {
        this.value = value;
    }
}
