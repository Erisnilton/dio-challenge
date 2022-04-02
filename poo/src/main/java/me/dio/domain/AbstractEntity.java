package me.dio.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@EqualsAndHashCode(of = "id")
@Accessors(chain = true, fluent = true)
@ToString
public abstract class AbstractEntity {

    private String id;

    private LocalDateTime createdAt;

    public AbstractEntity() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }

}
