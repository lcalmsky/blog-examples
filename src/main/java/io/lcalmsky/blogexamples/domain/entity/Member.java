package io.lcalmsky.blogexamples.domain.entity;

import io.lcalmsky.blogexamples.domain.entity.support.Gender;
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
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private Integer age;
    private Gender gender;
}
