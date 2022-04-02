package me.dio.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import static me.dio.domain.IContent.XP_DEFAULT;

@Getter
@Setter
@Accessors(chain = true, fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class Course extends AbstractEntity implements IContent {

    private String title;
    private String description;
    private int workload;

    public static Course create() {
        return new Course();
    }

    @Override
    public long calculateXP() {
        return XP_DEFAULT * workload;
    }

}
