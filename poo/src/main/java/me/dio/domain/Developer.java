package me.dio.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Accessors(chain = true, fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class Developer extends AbstractEntity {

    private String name;
    private Set<IContent> subscribedContent;
    private Set<IContent> completedContent;

    public static Developer create() {

        var dev = new Developer();

        dev.subscribedContent(new LinkedHashSet<>());
        dev.completedContent(new LinkedHashSet<>());

        return dev;

    }

    public Developer subscribeIn(Bootcamp bootcamp) {
        this.subscribedContent.addAll(bootcamp.contents());
        bootcamp.add(this);

        return this;
    }

    public void progress(IContent content) {
        completedContent.add(content);
    }

    public long totalXP() {
        return this.completedContent.stream().mapToLong(IContent::calculateXP).sum();
    }
}
