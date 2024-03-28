//package com.example.ipl.IplDashboard.util;
//
//import com.example.ipl.IplDashboard.model.Match;
//import com.example.ipl.IplDashboard.model.Team;
//import com.example.ipl.IplDashboard.repo.MatchRepository;
//import com.example.ipl.IplDashboard.repo.TeamRepository;
//import com.opencsv.CSVReader;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.Reader;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Slf4j
//@Service
//public class TeamDataHandler {
//
//    MatchRepository matchRepository;
//    TeamRepository teamRepository;
//    @Autowired
//    public TeamDataHandler(MatchRepository matchRepository,TeamRepository teamRepository){
//        this.teamRepository=teamRepository;
//        this.matchRepository=matchRepository;
//        loadCSVDataIntoDB();
//
//    }
//
//
//    public List<String[]> readLineByLine(Path filePath) throws Exception {
//        List<String[]> list = new ArrayList<>();
//
//        Map<String,Team> m= new HashMap<>();
//
//        try (Reader reader = Files.newBufferedReader(filePath)) {
//            try (CSVReader csvReader = new CSVReader(reader)) {
//                String[] line;
//                while ((line = csvReader.readNext()) != null) {
//
//                    String t1= line[5];
//                    String t2= line[6];
//                    String w= line[11];
//
//                    if(!m.containsKey(t1)){
//                        Team t= new Team();
//                        t.setTeamName(t1);
//                        m.put(t1,t);
//                    }
//                    if(!m.containsKey(t2)){
//                        Team t= new Team();
//                        t.setTeamName(t2);
//                        m.put(t2,t);
//                    }
//
//                    m.get(t1).setTotalMatches(m.get(t1).getTotalMatches()+1);
//                    m.get(t2).setTotalMatches(m.get(t2).getTotalMatches()+1);
//
//                    if(t1.equals(w)){
//                        m.get(t1).setTotalWins(m.get(t1).getTotalWins()+1);
//                    }
//                    if(t2.equals(w)){
//                        m.get(t2).setTotalWins(m.get(t2).getTotalWins()+1);
//                    }
//
//                    for(String t: m.keySet()){
//                        teamRepository.save(m.get(t));
//                    }
//
//                }
//            }
//        }
//        return list;
//    }
//
//
//    public void loadCSVDataIntoDB() {
//        try {
//            readLineByLine(Path.of("C:/Users/91734/Documents/IPL_Matches_2008_2022.csv"));
//
//        } catch (Exception ex) {
//            log.error("Error while reading csv file");
//        }
//    }
//
//}
