package com.example.herohaven.service.impl;

import com.example.herohaven.client.SteamApiClient;
import com.example.herohaven.dto.SteamUserDto;
import com.example.herohaven.mapper.SteamUserMapper;
import com.example.herohaven.repository.SteamUserRepository;
import com.example.herohaven.service.SteamUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SteamUserServiceImpl implements SteamUserService {
    private final SteamApiClient steamApiClient;
    private final SteamUserRepository steamUserRepository;
    private final SteamUserMapper steamUserMapper;

    @Override
    public SteamUserDto save(String userId) {
        SteamUserDto steamUser = steamApiClient.getSteamUser(userId);
        return steamUserMapper.toDto(
                steamUserRepository.save(
                        steamUserMapper.toModel(
                                steamUser
                        )
                )
        );
    }
}
