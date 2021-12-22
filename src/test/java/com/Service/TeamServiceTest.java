package com.Service;

import com.dao.TeamRepo;
import com.service.TeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

/**
 * The type Team service test.
 */
@ExtendWith(MockitoExtension.class)
public class TeamServiceTest {
    @Mock
    private TeamRepo teamRepo;

    @Mock
    private TeamService teamService;

    /**
     * Sets up.
     */


    /**
     * Gets all person.
     */
    @Test
    void getAllPerson() {
        teamService.listAll();
        (teamRepo).findAll();
    }

    /**
     * Get team.
     */
    @Test
    void getTeam(){
        teamService.findByname("CSK");
        verify(teamRepo).findByTeamname("CSK");
    }

    /**
     * Get teams.
     */
    @Test
    void getTeams(){
        teamService.teamNameExists("RCB");
        verify(teamRepo).findByTeamname("RCB");

    }

}

