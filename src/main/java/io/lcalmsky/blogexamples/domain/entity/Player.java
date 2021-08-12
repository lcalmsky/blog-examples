package io.lcalmsky.blogexamples.domain.entity;

import io.lcalmsky.blogexamples.domain.entity.support.Position;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class Player {
    @Id
    @GeneratedValue
    @Column(name = "player_id")
    private Long id;
    private String name;
    private Integer age;
    private Position position;
}