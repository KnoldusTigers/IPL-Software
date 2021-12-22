package com.service;
import com.dao.TeamRepo;
import com.model.TeamModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepo repo;

    public List<TeamModel> listAll() {

        return repo.findAll();
    }
    public void save(TeamModel Teams) {

        repo.save(Teams);
    }
    public TeamModel get(Long Id) {

        return repo.findById((Id)).get();
    }
    @Transactional
    public Optional<TeamModel> findByname(String teamname) {
        return repo.findByTeamname(teamname);
    }
    public boolean teamNameExists(String teamname){
        return findByname(teamname).isPresent();
    }
}
