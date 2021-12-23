package com.service;
import com.dao.TeamRepo;
import com.model.TeamModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * The type Team service.
 */
@Service
public class TeamService {

    @Autowired
    private TeamRepo teamRepo;



    /**
     * List all list.
     *
     * @return the list
     */
    public List<TeamModel> listAll() {

        return teamRepo.findAll();
    }

    /**
     * Save teams.
     *
     * @param Teams the teams
     */
    public void saveTeams(TeamModel Teams) {

        teamRepo.save(Teams);
    }

    /**
     * Gets ids.
     *
     * @param Id the id
     * @return the ids
     */
    public TeamModel getIds(Long Id) {

        return teamRepo.findById((Id)).get();
    }

    /**
     * Find byname optional.
     *
     * @param teamname the teamname
     * @return the optional
     */
    @Transactional
    public Optional<TeamModel> findByname(String teamname) {
        return teamRepo.findByTeamname(teamname);
    }

    /**
     * Team name exists boolean.
     *
     * @param teamname the teamname
     * @return the boolean
     */
    public boolean teamNameExists(String teamname) {
        return findByname(teamname).isPresent();
    }


}
