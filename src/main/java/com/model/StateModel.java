package com.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class StateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)

    private Long id;
    @OneToMany(mappedBy = "stateModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MatchModel> addStates;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    private String state;
    private String venue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
