package com.dao;

import com.model.PlayersModel;
import com.model.TeamModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepo extends JpaRepository<TeamModel, Long> {
    Optional<TeamModel> findByTeamname(String teamname);

}
