package com.example.ipl.IplDashboard.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.websocket.server.ServerEndpoint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Slf4j
@Entity
@ToString
@Table(name="teamTable")

public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String teamName;

    private int totalMatches;

    private int totalWins;

    @Transient
    private List<Match> latestMatches;
    public Team(String teamName){
        this.teamName=teamName;
        this.totalWins=0;
        this.totalMatches=0;
    }



}

