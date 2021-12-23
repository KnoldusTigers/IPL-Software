package com.dao;

import com.model.PlayersModel;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * The interface Player repo.
 */
@Repository

public interface PlayerRepo extends CrudRepository<PlayersModel, Integer> {

 /**
  * Find by team id list.
  *
  * @param team_id the team id
  * @return the list
  */
//@Query(value = "select player_name from players  where players.team_id=team.team_id", nativeQuery = true)
//
 List<PlayersModel> findByTeamId(Long team_id);

 /**
  * Find by name optional.
  *
  * @param playername the playername
  * @return the optional
  */
 Optional<PlayersModel> findByName(String playername);
 //  public List<PlayersModel> getAllPlayers();

}
