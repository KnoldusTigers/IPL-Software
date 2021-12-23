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
    public MatchModel get(int Id) {

        return matchRepo.findById(Id).get();
    }


    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(int id) {

        matchRepo.deleteById(id);
    }

    /**
     * Find venue is exist optional.
     *
     * @param venue the venue
     * @return the optional
     */
//public boolean cehckVenue(String schduledate, String venue){
//
//        for(int i=0;i<3;i++){
//            MatchModel matchModelVenue=matchRepo.findByVenue(venue).get();
//            MatchModel matchModelDate=matchRepo.findByScheduledate(schduledate).get();
//            if(matchModelVenue==null || matchModelDate==null){
//                return false;
//            }
//             if(matchModelVenue.getMatchid()==matchModelDate.getMatchid()){
//    System.out.println("=-==============----------------================="+i);
//    return true;
//              }
//        }
//
//    return false;
//}
//
    @Transactional
    public Optional<MatchModel> findVenueIsExist (String venue) {
        return matchRepo.findByVenue(venue);
    }

    /**
     * Venue exists boolean.
     *
     * @param venue  the venue
     * @param result the result
     * @return the boolean
     */
    public boolean venueExists (String venue, BindingResult result) {
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
    public Optional<MatchModel> findDateIsExist (String date) {

        return matchRepo.findByScheduledate(date);

    }

    /**
     * Date is exist boolean.
     *
     * @param date   the date
     * @param result the result
     * @return the boolean
     */
    public boolean DateIsExist (String date, BindingResult result) {
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
    public Optional<MatchModel> findTeam (TeamModel team1) {

        return matchRepo.findByTeam1(team1);

    }

    /**
     * Team is exist boolean.
     *
     * @param team1  the team 1
     * @param result the result
     * @return the boolean
     */
    public boolean teamIsExist (TeamModel team1, BindingResult result) {
        try {
            return findTeam(team1).isPresent(); }
        catch (Exception e) {
            result.addError(new FieldError("match", "team1", "teams already exist"));
        }
        return false;


    }

}