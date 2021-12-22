package com.service;

import com.dao.StateRepo;
import com.dao.TeamRepo;
import com.model.StateModel;
import com.model.TeamModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {
    @Autowired
    private StateRepo stateRepo;


    public List<StateModel> listAllStates() {

        return stateRepo.findAll();
    }

}
