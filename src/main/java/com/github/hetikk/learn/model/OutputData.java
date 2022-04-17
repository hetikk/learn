package com.github.hetikk.learn.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Getter
@Setter
public class OutputData {

    private static final Random RANDOM = new Random();

    public String uuid;

    public String name;

    public Integer age;

    public LocalDateTime createdAt;

    public LocalDateTime updatedAt;

    public static OutputData withDefaultParams() {
        OutputData output = new OutputData();
        output.uuid = UUID.randomUUID().toString();
        output.name = "hetikk";
        output.age = RANDOM.nextInt();
        output.createdAt = LocalDateTime.now();
        output.updatedAt = output.createdAt;
        return output;
    }

}
