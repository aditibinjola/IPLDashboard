package com.example.ipl.IplDashboard.repo;

import com.example.ipl.IplDashboard.model.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team,Integer> {

    @Query(value="select* from team_table where team_table.team_name=?1 limit 1;",nativeQuery = true)
    Team getByName(String teams);
}
