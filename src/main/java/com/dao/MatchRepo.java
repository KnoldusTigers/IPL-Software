package com.dao;

import com.model.MatchModel;
import com.model.TeamModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Match repo.
 */
public interface MatchRepo extends CrudRepository<MatchModel, Integer> {
    /**
     * Find by venue optional.
     *
     * @param venue the venue
     * @return the optional
     */
//    List<PlayersModel> findByTeamId(String team_id);
    Optional<MatchModel> findByVenue(String venue);

    /**
     * Find by scheduledate optional.
     *
     * @param date the date
     * @return the optional
     */
    Optional<MatchModel> findByScheduledate(String date);

    public Optional<MatchModel> findByTeam1(TeamModel team1);
    List<MatchModel> findAllByTeam1(TeamModel team1);

}