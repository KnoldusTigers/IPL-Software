package com.dao;

import com.model.PlayersModel;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository

public interface PlayerRepo extends CrudRepository<PlayersModel, Integer> {

 //@Query(value = "select player_name from players  where players.team_id=team.team_id", nativeQuery = true)
//
 List<PlayersModel> findByTeamId(Long team_id);

 Optional<PlayersModel> findByName(String playername);
 //  public List<PlayersModel> getAllPlayers();

}
