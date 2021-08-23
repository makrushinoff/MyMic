package com.example.mymic.dto.post;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class PostRequestDto {

    @NotNull
    private String message;

    @NotNull
    private String title;

    @NotNull
    private UUID userId;

}
