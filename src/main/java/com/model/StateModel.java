package com.model;

import javax.persistence.*;
import java.util.Set;

/**
 * The type State model.
 */
@Entity
public class StateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)

    private Long id;
    @OneToMany(mappedBy = "stateModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<MatchModel> addStates;

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(final String state) {
        this.state = state;
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
    private String state;
    private String venue;
    public void setVenue(final String venue) {
        this.venue = venue;
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
    public void setId(final Long id) {
        this.id = id;
    }

}
