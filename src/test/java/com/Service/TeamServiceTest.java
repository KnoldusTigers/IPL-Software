package com.Service;

import com.dao.TeamRepo;
import com.service.TeamService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

/**
 * The type Team service test.
 */
@ExtendWith(MockitoExtension.class)
class TeamServiceTest {
    @Mock
    private TeamRepo teamRepo;

    @Mock
    private TeamService teamService;


    /**
     * Gets all person.
     */
    @Test
    /* default */void getAllPerson() {
        teamService.listAll();
        (teamRepo).findAll();
        Assertions.assertEquals(teamService.listAll(), teamRepo.findAll());
    }

    /**
     * Get team1.
     */
    @Test
    /* default */void getTeam1(){
        teamService.findByname("CSK");
        verify(teamRepo).findByTeamname("CSK");
    }

    /**
     * Get team2.
     */
    @Test
    /* default */void getTeam2(){
        teamService.teamNameExists("RCB");
        verify(teamRepo).findByTeamname("RCB");

    }

    /**
     *  Get team3
     */
    @Test
    /* default */void getTeam3(){
        teamService.teamNameExists("RR");
        verify(teamRepo).findByTeamname("RR");
    }

}

