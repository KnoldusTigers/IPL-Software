package com.Service;
import com.dao.TeamRepo;

import com.model.TeamModel;
import com.service.TeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
class TeamServiceTest {

    @Autowired
    TeamRepo teamRepo;

    @Autowired
    TeamService teamService;




    @Test
    void saveTeam_ReturnTrueIfGivenTeamIsSaved() {
        TeamModel team3 = new TeamModel(3L,"KXIP","yuvraj","punjab");
        teamService.saveTeams(team3);
        assertTrue(teamService.findByname(team3.getTeamname()).isPresent());
    }
//
//    @Test
//    void getNewTeamObject_CorrectIfReturnNewTeamObject() {
//        Team team = teamService.getNewTeamObject();
//        assertInstanceOf(Team.class, team);
//    }

//    @Test
//    void getTeamById_ReturnTrueIfTeamFound(){
//        Boolean actual = teamService.getTeamById(2L).isPresent();
//        assertTrue(actual);
//    }
//
    @Test
    void getAllTeams_ReturnTrueIfReturnTeamList() {
        List<TeamModel> teams = teamService.listAll();
        int actualSize = teams.size();
        System.out.println(actualSize);
        assertTrue(actualSize > 1);
    }

    @Test
    void getTeamByName_ReturnTrueIfTeamFound(){
        boolean actual = teamService.findByname("CSK").isPresent();
        System.out.println(actual);
        assertTrue(actual);
    }


}