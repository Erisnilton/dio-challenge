package me.dio.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true, fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Mentorship extends AbstractEntity implements IContent {

    private String title;
    private String description;
    private LocalDateTime dateTime;

    public static Mentorship create() {
        return new Mentorship();
    }

    @Override
    public long calculateXP() {
        return XP_DEFAULT + 20;
    }

}
