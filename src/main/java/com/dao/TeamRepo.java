package com.dao;

import com.model.PlayersModel;
import com.model.TeamModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Team repo.
 */
@Repository
public interface TeamRepo extends JpaRepository<TeamModel, Long> {

    /**
     * Find by teamname optional.
     *
     * @param teamname the teamname
     * @return the optional
     */
    Optional<TeamModel> findByTeamname(String teamname);

 }
