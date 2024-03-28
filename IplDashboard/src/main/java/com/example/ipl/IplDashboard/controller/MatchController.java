package com.example.ipl.IplDashboard.controller;

import com.example.ipl.IplDashboard.model.Match;
import com.example.ipl.IplDashboard.repo.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/")

public class MatchController {
    @Autowired
    MatchRepository m;

    @GetMapping("/read")
    public String readCSV() {

        return "test";
    }
    @GetMapping("/getteam1")
    public Set<String> getTeams(){

        return m.getAllTeam1();
    }



}
