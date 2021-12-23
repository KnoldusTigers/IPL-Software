package com.model;

import javax.persistence.*;

/**
 * The type Point model.
 */
@Entity
public class PointModel {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamModel team;

    private int winCount;
    private int lossCount;
    private int matchCount;
    private int point;

    /**
     * Gets point.
     *
     * @return the point
     */
    public int getPoint() {
        return point;
    }

    /**
     * Sets point.
     *
     * @param point the point
     */
    public void setPoint(int point) {
        this.point = point;
    }

    /**
     * Gets team.
     *
     * @return the team
     */
    public TeamModel getTeam() {
        return team;
    }

    /**
     * Gets win count.
     *
     * @return the win count
     */
    public int getWinCount() {
        return winCount;
    }

    /**
     * Sets win count.
     *
     * @param winCount the win count
     */
    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    /**
     * Gets loss count.
     *
     * @return the loss count
     */
    public int getLossCount() {
        return lossCount;
    }

    /**
     * Sets loss count.
     *
     * @param lossCount the loss count
     */
    public void setLossCount(int lossCount) {
        this.lossCount = lossCount;
    }

    /**
     * Gets match count.
     *
     * @return the match count
     */
    public int getMatchCount() {
        return matchCount;
    }

    /**
     * Sets match count.
     *
     * @param matchCount the match count
     */
    public void setMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    /**
     * Sets team.
     *
     * @param team the team
     */
    public void setTeam(TeamModel team) {
        this.team = team;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }
}