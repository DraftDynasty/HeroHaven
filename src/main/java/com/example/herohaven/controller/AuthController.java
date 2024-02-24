package com.example.herohaven.controller;

import com.example.herohaven.client.SteamApiClient;
import com.example.herohaven.dto.SteamUserDto;
import com.example.herohaven.service.SteamUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final SteamUserService steamUserService;

    @PostMapping("/login")
    public SteamUserDto login(@RequestParam String steamId) {
        return steamUserService.save(steamId);
    }
}

