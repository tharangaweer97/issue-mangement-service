package com.developertracker.issuemanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    @JsonProperty("login")
    private String login;

    @JsonProperty("type")
    private String type;
}

