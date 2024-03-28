package com.example.ipl.IplDashboard.repo;

import com.example.ipl.IplDashboard.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team,Integer> {

}
