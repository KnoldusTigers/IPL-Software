package com.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "team")
public class TeamModel {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @NotNull
    @Size(min = 2, max = 30)
    private String teamname;
    private String state;
    private String captain;

    @OneToMany(mappedBy = "team")
    private List<PlayersModel> playersModel;

    @OneToMany(mappedBy = "team")
   private List<PointModel> pointModels;

    public TeamModel(final long id, final String teamname, final String captain, final String state) {
        this.teamname = teamname;
        this.captain = captain;
        this.state = state;
        this.id = id;
    }

    public TeamModel(final long id) {
        this.id = id;
    }



    public List<PointModel> getPointModels() {
        return pointModels;
    }

    public void setPointModels(final List<PointModel> pointModels) {
        this.pointModels = pointModels;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(final String teamname) {
        this.teamname = teamname;
    }

    public Long getId() {

        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }



    public List<PlayersModel> getPlayersModel() {
        return playersModel;
    }

    public void setPlayersModel(final List<PlayersModel> playersModel) {
        this.playersModel = playersModel;
    }

    public String getState() {
        return state;
    }

    public void setState(final String state) {
        this.state = state;
    }



    public String getCaptain() {
        return captain;
    }

    public void setCaptain(final String captain) {
        this.captain = captain;
    }

    public TeamModel() {
        // commented empty constructor

    }
}