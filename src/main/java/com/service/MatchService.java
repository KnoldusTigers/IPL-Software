package com.service;


import com.dao.MatchRepo;
import com.model.MatchModel;
import com.model.TeamModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


/**
 * The type Match service.
 */
@Service
public class MatchService {
    @Autowired
    private MatchRepo matchRepo;

    /**
     * Gets all matches.
     *
     * @return the all matches
     */
    public List<MatchModel> getAllMatches() {
//        System.out.println(getPlayers());

        return (List<MatchModel>) matchRepo.findAll();
    }

    /**
     * Save.
     *
     * @param match_model the match model
     */
    public void save(final MatchModel match_model) {

        matchRepo.save(match_model);
    }

    /**
     * Get match model.
     *
     * @param Id the id
     * @return the match model
     */
    public MatchModel get(final int Id) {

        return matchRepo.findById(Id).get();
    }


    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(final int id) {

        matchRepo.deleteById(id);
    }

    /**
     * @param venue the venue
     * @return the optional
     */

    @Transactional
    public Optional<MatchModel> findVenueIsExist (final String venue) {
        return matchRepo.findByVenue(venue);
    }

    /**
     * Venue exists boolean.
     *
     * @param venue  the venue
     * @param result the result
     * @return the boolean
     */
    public boolean venueExists (final String venue, final BindingResult result) {
        try {
            return findVenueIsExist(venue).isPresent(); }
        catch (Exception e) {
            result.addError(new FieldError("match", "scheduledate", "date or venue already exist"));
        }
        return false;
    }

    /**
     * Find date is exist optional.
     *
     * @param date the date
     * @return the optional
     */
    @Transactional
    public Optional<MatchModel> findDateIsExist (final String date) {

        return matchRepo.findByScheduledate(date);

    }

    /**
     * Date is exist boolean.
     *
     * @param date   the date
     * @param result the result
     * @return the boolean
     */
    public boolean DateIsExist (final String date, final BindingResult result) {
        try {
            return findDateIsExist(date).isPresent(); }
        catch (Exception e) {
            result.addError(new FieldError("match", "scheduledate", "teams already schedule on same date"));
        }
        return false;

    }

    /**
     * Find team optional.
     *
     * @param team1 the team 1
     * @return the optional
     */
    @Transactional
    public Optional<MatchModel> findTeam (final TeamModel team1) {

        return matchRepo.findByTeam1(team1);

    }

    /**
     * Team is exist boolean.
     *
     * @param team1  the team 1
     * @param result the result
     * @return the boolean
     */
    public boolean teamIsExist (final TeamModel team1, final BindingResult result) {
        try {
            return findTeam(team1).isPresent(); }
        catch (Exception e) {
            result.addError(new FieldError("match", "team1", "teams already exist"));
        }
        return false;


    }

}
