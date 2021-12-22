package com.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "players")
@Table(name = "players")

public class PlayersModel  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @NotNull
    @Size(min=2, max=30)
    private String name;
    //     private String player_team;
    @NotNull(message = "role can't be blank")
    @Size(min=2, max=30)
    private String player_role;


    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamModel team;

    public TeamModel getTeam() {
        return team;
    }

    public void setTeam(TeamModel team) {
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return  name;
    }

    public void setName(String name) {
        this. name =  name;
    }

    public String getPlayer_role() {
        return player_role;
    }

    public void setPlayer_role(String player_role) {
        this.player_role = player_role;
    }

}
