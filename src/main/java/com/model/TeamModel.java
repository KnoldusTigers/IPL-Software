package com.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "team")
public class TeamModel {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @NotNull
    @Size(min=2, max=30)
    private String teamname;
    private String state;
    private String captain;

    @OneToMany(mappedBy = "team1", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MatchModel> addteam1;

    @OneToMany(mappedBy = "team2", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MatchModel> addteam2;

    @OneToMany(mappedBy = "team")
    List<PlayersModel> playersModel;

    @OneToMany(mappedBy = "team")
    List<PointModel> pointModels;

    public TeamModel(long id, String teamname, String captain,String state) {
        this.teamname=teamname;
        this.captain=captain;
        this.state=state;
        this.id=id;
    }

    public TeamModel(long id) {
        this.id=id;
    }



    public List<PointModel> getPointModels() {
        return pointModels;
    }

    public void setPointModels(List<PointModel> pointModels) {
        this.pointModels = pointModels;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public Long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public List<PlayersModel> getPlayersModel() {
        return playersModel;
    }

    public void setPlayersModel(List<PlayersModel> playersModel) {
        this.playersModel = playersModel;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }



    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }



//    //constructer
//    public TeamModel(String teamname, Set<MatchModel> addteam2, List<PlayersModel> playersModel) {
//
//        this.teamname = teamname;
//        this.addteam2 = addteam2;
//        this.playersModel = playersModel;
//    }
    public TeamModel() {

    }
}
