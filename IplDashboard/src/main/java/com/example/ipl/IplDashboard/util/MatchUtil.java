package com.example.ipl.IplDashboard.util;

import com.example.ipl.IplDashboard.model.Match;
import com.example.ipl.IplDashboard.model.Team;
import com.example.ipl.IplDashboard.repo.MatchRepository;
import com.example.ipl.IplDashboard.repo.TeamRepository;
import com.opencsv.CSVReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Slf4j
public class MatchUtil {
    MatchRepository matchRepository;
    TeamRepository teamRepository;
    @Autowired
    public MatchUtil(MatchRepository matchRepository,TeamRepository teamRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository= teamRepository;
        loadCSVDataIntoDB();
    }


    public List<String[]> readLineByLine(Path filePath) throws Exception {
        List<String[]> list = new ArrayList<>();
        Map<String, Team> m= new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);

        try (Reader reader = Files.newBufferedReader(filePath)) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                String[] line;
                while ((line = csvReader.readNext()) != null) {

                    Match match = new Match();
                    match.setID(Long.parseLong(line[0]));
                    match.setCity(line[1]);
                    match.setMatchDate(LocalDate.parse(line[2],formatter));
//                    match.setMatchDate(LocalDate.parse(line[2]);
//                    match.setDate(LocalDate.parse(line[2]));
//                    match.setSeason(Integer.parseInt(line[3]));
                    match.setSeason((line[3]));
                    match.setMatchNumber(line[4]);
                    match.setTeam1(line[5]);
                    match.setTeam2(line[6]);
                    match.setVenue(line[7]);
                    match.setTossWinner(line[8]);
                    match.setTossDecison(line[9]);
                    match.setSuperOver(line[10]);
                    match.setWinningTeam(line[11]);
                    match.setWonBy(line[12]);
//                    match.setMargin(Integer.parseInt(line[13]));
                    match.setMargin(line[13]);
                    match.setMethod(line[14]);
                    match.setPlayer_of_Match(line[15]);
                    match.setTeam1Players(String.join(",",line[16]));
                    match.setTeam2Players(String.join(",",line[17]));
                    match.setUmpire1(line[18]);
                    match.setUmpire2(line[19]);

//                    matches.add(match);
                    matchRepository.save(match);


                    String t1= line[5];
                    String t2= line[6];
                    String w= line[11];

                    if(!m.containsKey(t1)){
                        Team t= new Team();
                        t.setTeamName(t1);
                        m.put(t1,t);
                    }
                    if(!m.containsKey(t2)){
                        Team t= new Team();
                        t.setTeamName(t2);
                        m.put(t2,t);
                    }

                    m.get(t1).setTotalMatches(m.get(t1).getTotalMatches()+1);
                    m.get(t2).setTotalMatches(m.get(t2).getTotalMatches()+1);

                    if(m.get(t1).getTeamName().equals(w)){
                        m.get(t1).setTotalWins(m.get(t1).getTotalWins()+1);
                    }
                    if(m.get(t2).getTeamName().equals(w)){
                        m.get(t2).setTotalWins(m.get(t2).getTotalWins()+1);
                    }
                    m.put(t1,m.get(t1));
                    m.put(t2,m.get(t2));

                }
                System.out.println(m.values());
                teamRepository.saveAll(m.values());
//                for(String t: m.keySet()){
//                    teamRepository.save(m.get(t));
//                }
            }
        }
        return list;
    }


        public void loadCSVDataIntoDB() {
            try {
                readLineByLine(Path.of("C:/Users/91734/Documents/IPL_Matches_2008_2022.csv"));

            } catch (Exception ex) {
                log.error("Error while reading csv file");
            }
        }




    }

