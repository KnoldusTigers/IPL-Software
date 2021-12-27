package com.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The type Players model.
 */
@Entity(name = "players")
@Table(name = "players")

public class PlayersModel  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @NotNull
    @Size(min = 2, max = 30)
    private String name;


    @NotNull(message = "role can't be blank")
    @Size(min = 2, max = 30)
    private String player_role;


    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamModel team;

    /**
     * Gets team.
     *
     * @return the team
     */
    public TeamModel getTeam() {
        return team;
    }

    /**
     * Sets team.
     *
     * @param team the team
     */
    public void setTeam(final TeamModel team) {
        this.team = team;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return  name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(final String name) {
        this.name =  name;
    }

    /**
     * Gets player role.
     *
     * @return the player role
     */
    public String getPlayer_role() {
        return player_role;
    }

    /**
     * Sets player role.
     *
     * @param player_role the player role
     */
    public void setPlayer_role(final String player_role) {
        this.player_role = player_role;
    }

}
