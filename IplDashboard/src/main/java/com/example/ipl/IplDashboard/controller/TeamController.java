package com.example.ipl.IplDashboard.controller;

import com.example.ipl.IplDashboard.model.Match;
import com.example.ipl.IplDashboard.model.Team;
import com.example.ipl.IplDashboard.repo.MatchRepository;
import com.example.ipl.IplDashboard.repo.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class TeamController {
    TeamRepository teamRepository;
    MatchRepository matchRepository;
    @Autowired
    TeamController(TeamRepository teamRepository, MatchRepository matchRepository){
        this.teamRepository= teamRepository;
        this.matchRepository= matchRepository;
    }
//    @GetMapping("/team")
//    public Team getTeam(@RequestParam String teamName){
//        Team t= teamRepository.getByTeamName();
//        List<Match> matchList= matchRepository.getLatest4MatchesByteamName();
//        t.setLatestMatches(matchList);
//        return t;
//    }


}
