package com.example.herohaven.dto;

import lombok.Data;

import java.util.List;

@Data
public class SteamUserResponseInner {
    private List<SteamUserDto> players;
}
