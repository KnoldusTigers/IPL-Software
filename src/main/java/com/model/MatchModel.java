package com.model;



import com.validations.MatchValidation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The type Match model.
 */
@Entity
@Table(name = "MatchScheduling")
@MatchValidation
public class MatchModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "matchid", nullable = false)
    private int matchid;
    @NotNull
    @Size(min = 4, message = "fill all fields")
    private String  scheduledate;
    private String time;
    private String venue;

    /**
     * Gets time.
     *
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(String time) {
        this.time = time;
    }

    private String team1Description;

    /**
     * Gets time.
     *
     * @return the time
     */

    private String team2Description;

    @Column(name = "team1_wickets", nullable = true)
    private String team1Wickets;

    @Column(name = "team2_wickets", nullable = true)
    private String team2Wickets;
    @Column(name = "team1_overs", nullable = true)
    private Double team1Overs;
    @Column(name = "team2_overs", nullable = true)

    private Double team2Overs;
    @ManyToOne
    @JoinColumn(name = "states")
    private StateModel stateModel;

    @ManyToOne
    @JoinColumn(name = "teamid1")
    private TeamModel team1;

    @ManyToOne
    @JoinColumn(name = "teamid2")
    private TeamModel team2;


    private String result;

    /**
     * Gets team 2 description.
     *
     * @return the team 2 description
     */
    public String getTeam2Description() {
        return team2Description;
    }

    /**
     * Sets team 2 description.
     *
     * @param team2Description the team 2 description
     */
    public void setTeam2Description(final String team2Description) {
        this.team2Description = team2Description;
    }

    /**
     * Gets team 1 wickets.
     *
     * @return the team 1 wickets
     */
    public String getTeam1Wickets() {
        return team1Wickets;
    }

    /**
     * Sets team 1 wickets.
     *
     * @param team1Wickets the team 1 wickets
     */
    public void setTeam1Wickets(final String team1Wickets) {
        this.team1Wickets = team1Wickets;
    }

    /**
     * Gets team 2 wickets.
     *
     * @return the team 2 wickets
     */
    public String getTeam2Wickets() {
        return team2Wickets;
    }

    /**
     * Sets team 2 wickets.
     *
     * @param team2Wickets the team 2 wickets
     */
    public void setTeam2Wickets(final String team2Wickets) {
        this.team2Wickets = team2Wickets;
    }

    /**
     * Gets team 1 overs.
     *
     * @return the team 1 overs
     */
    public Double getTeam1Overs() {
        return team1Overs;
    }

    /**
     * Sets team 1 overs.
     *
     * @param team1Overs the team 1 overs
     */
    public void setTeam1Overs(final Double team1Overs) {
        this.team1Overs = team1Overs;
    }

    /**
     * Gets team 2 overs.
     *
     * @return the team 2 overs
     */
    public Double getTeam2Overs() {
        return team2Overs;
    }

    /**
     * Sets team 2 overs.
     *
     * @param team2Overs the team 2 overs
     */
    public void setTeam2Overs(final Double team2Overs) {
        this.team2Overs = team2Overs;
    }


    /**
     * Gets state model.
     *
     * @return the state model
     */
    public StateModel getStateModel() {
        return stateModel;
    }

    /**
     * Sets state model.
     *
     * @param stateModel the state model
     */
    public void setStateModel(final StateModel stateModel) {
        this.stateModel = stateModel;
    }

    /**
     * Gets team 1 description.
     *
     * @return the team 1 description
     */
    public String getTeam1Description() {
        return team1Description;
    }

    /**
     * Sets team 1 description.
     *
     * @param team1Description the team 1 description
     */
    public void setTeam1Description(final String team1Description) {
        this.team1Description = team1Description;
    }

    /**
     * Gets team 1.
     *
     * @return the team 1
     */
    public TeamModel getTeam1() {
        return team1;
    }

    /**
     * Sets team 1.
     *
     * @param team1 the team 1
     */
    public void setTeam1(final TeamModel team1) {
        this.team1 = team1;
    }

    /**
     * Gets team 2.
     *
     * @return the team 2
     */
    public TeamModel getTeam2() {
        return team2;
    }

    /**
     * Sets team 2.
     *
     * @param team2 the team 2
     */
    public void setTeam2(final TeamModel team2) {
        this.team2 = team2;
    }


    /**
     * Gets matchid.
     *
     * @return the matchid
     */
    public int getMatchid() {
        return matchid;
    }

    /**
     * Gets scheduledate.
     *
     * @return the scheduledate
     */
    public String getScheduledate() {
        return scheduledate;
    }

    /**
     * Sets scheduledate.
     *
     * @param scheduledate the scheduledate
     */
    public void setScheduledate(final String scheduledate) {
        this.scheduledate = scheduledate;
    }

    /**
     * Sets matchid.
     *
     * @param matchid the matchid
     */
    public void setMatchid(final int matchid) {
        this.matchid = matchid;
    }


    /**
     * Gets venue.
     *
     * @return the venue
     */
    public String getVenue() {
        return venue;
    }

    /**
     * Sets venue.
     *
     * @param venue the venue
     */
    public void setVenue(final String venue) {
        this.venue = venue;
    }

    /**
     * Gets result.
     *
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * Sets result.
     *
     * @param result the result
     */
    public void setResult(final String result) {
        this.result = result;
    }

}