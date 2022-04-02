package me.dio.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Accessors(chain = true, fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Bootcamp extends AbstractEntity {

    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    private Set<Developer> developers;
    private Set<IContent> contents;

    public static Bootcamp create() {
        var bootcamp = new Bootcamp();

        bootcamp.developers(new HashSet<>());
        bootcamp.contents(new LinkedHashSet<>());

        return bootcamp;
    }

    public void add(Developer developer) {
        this.developers.add(developer);
    }

    public void add(IContent content) {
        this.contents.add(content);
    }

}
