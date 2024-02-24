package com.example.herohaven.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Data
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "steam_user")
@SQLDelete(sql = "UPDATE addresses SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
public class SteamUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String steamid;
    @Column(nullable = false)
    private String personaname;
    @Column(nullable = false)
    private String profileurl;
    @Column(nullable = false)
    private String avatar;
    @Column(nullable = false)
    private String avatarmedium;
    @Column(nullable = false)
    private String avatarfull;
    @Column(nullable = false)
    private String avatarhash;
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;
}
