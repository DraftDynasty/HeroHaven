package com.example.herohaven.client;

import com.example.herohaven.dto.SteamUserDto;
import com.example.herohaven.dto.SteamUserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SteamApiClient {
    @Value("${steam.api.key}")
    private String apiKey;
    private final String steamApiUrl = "https://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/";
    private final ObjectMapper objectMapper;

    public SteamUserDto getSteamUser(String steamId) {
        HttpClient httpClient = HttpClient.newHttpClient();
        String url = steamApiUrl + "?key=" + apiKey + "&steamids=" + steamId;
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = httpClient
                    .send(
                            httpRequest,
                            HttpResponse.BodyHandlers.ofString()
                    );

            SteamUserResponse steamUserResponse = objectMapper.readValue(
                    response.body(),
                    SteamUserResponse.class
            );
            List<SteamUserDto> players = steamUserResponse.getResponse().getPlayers();
            if (players != null && !players.isEmpty()) {
                return players.get(0);
            } else {
                return null;
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
