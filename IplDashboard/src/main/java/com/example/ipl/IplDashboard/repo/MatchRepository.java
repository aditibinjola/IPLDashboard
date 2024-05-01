package com.example.ipl.IplDashboard.repo;

import com.example.ipl.IplDashboard.model.Match;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface MatchRepository extends CrudRepository<Match,Long> {

    @Query(value = "select * from matches where matches.team1=:teams or matches.team2=:teams order by matches.match_date desc limit 4",nativeQuery = true)
    List<Match> GetMatchInfo(@Param("teams") String teams);

    @Query(value = "SELECT * FROM matches WHERE (matches.team1 = :team OR matches.team2 = :team) AND (matches.match_Date >= :startOfYear AND matches.match_Date <= :endOfYear)", nativeQuery = true)
    List<Match> getMatchesByYear(@Param("team") String team, @Param("startOfYear") LocalDate startOfYear, @Param("endOfYear") LocalDate endOfYear);


//    List<Match> getByTeam1OrTeam2(String teamName1, String teamName2);

//    @Query(value="select matches.team1 from matches",nativeQuery = true)
//    Set<String> getAllTeam1();
//    @Query("select matches.team2 from matches")
//    Set<String> getAllTeam2();
//


}
