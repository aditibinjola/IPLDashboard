package com.example.ipl.IplDashboard.repo;

import com.example.ipl.IplDashboard.model.Match;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MatchRepository extends CrudRepository<Match,Long> {
    @Query(value="select matches.team1 from matches",nativeQuery = true)
    Set<String> getAllTeam1();
////
//    @Query("select matches.team2 from matches")
//    Set<String> getAllTeam2();
//
//    @Query(value = "select* from matchdata where matchdata.team1=:teams or matchdata.team2=:teams order by date desc limit 4",nativeQuery = true)
//    List<Match> getMatchInfo();

}
