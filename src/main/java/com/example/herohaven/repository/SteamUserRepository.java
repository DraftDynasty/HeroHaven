package com.example.herohaven.repository;

import com.example.herohaven.model.SteamUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SteamUserRepository extends JpaRepository<SteamUser, Long> {
}
