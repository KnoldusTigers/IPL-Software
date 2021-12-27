package com.Repositry;

import com.dao.TeamRepo;
import com.model.TeamModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class TeamRepoTest {


    @Autowired
    private TeamRepo teamRepo;

    @Test
        /* default */void isTeamExist() {
        final Optional<TeamModel> actualResult = teamRepo.findByTeamname("CSK");
        assertThat(actualResult).isPresent();
    }



    }