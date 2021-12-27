package com.Controller;


import com.dao.TeamRepo;
import com.controller.TeamController;
import com.service.TeamService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

// Injecting mock for teamController
 public class TeamControllerTest {


    @InjectMocks
    /* default */TeamController teamController;

    @Mock
    /* default */ TeamRepo teamRepo;

    @Mock
    /* default */TeamService teamService;

//    @Test
//    public void saveUserTest() {
////        TeamModel user = new TeamModel(1,"CSK", "M.S Dhoni",  "Chennai");
//        when(teamRepo.save(user)).thenReturn(user);
//        assertEquals(user,teamRepo.save(user));
//    }
}
