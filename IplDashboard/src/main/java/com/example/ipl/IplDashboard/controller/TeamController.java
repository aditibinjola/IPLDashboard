package com.example.ipl.IplDashboard.controller;

import com.example.ipl.IplDashboard.model.Match;
import com.example.ipl.IplDashboard.model.Team;
import com.example.ipl.IplDashboard.repo.MatchRepository;
import com.example.ipl.IplDashboard.repo.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/")
@CrossOrigin

public class TeamController {
    TeamRepository teamRepository;
    MatchRepository matchRepository;
    @Autowired
    TeamController(TeamRepository teamRepository, MatchRepository matchRepository){
        this.teamRepository= teamRepository;
        this.matchRepository= matchRepository;
    }
    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName){
        Team t= teamRepository.getByName(teamName);
        List<Match> matchList= matchRepository.GetMatchInfo(teamName);
        t.setLatestMatches(matchList);
        return t;
    }
    @GetMapping("/{teamName}")
    public Team getTeamtest(@PathVariable String teamName){
        Team t=teamRepository.getByName(teamName);
        return t;
    }
    @GetMapping("/team")
    public Iterable<Team> getAllTeam(){
        return this.teamRepository.findAll();
    }
}
