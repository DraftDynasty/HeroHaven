package com.example.herohaven.mapper;

import com.example.herohaven.config.MapperConfig;
import com.example.herohaven.dto.SteamUserDto;
import com.example.herohaven.model.SteamUser;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface SteamUserMapper {
    SteamUser toModel(SteamUserDto steamUserDto);

    SteamUserDto toDto(SteamUser steamUser);
}
