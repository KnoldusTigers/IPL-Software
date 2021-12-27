package com.service;

import com.dao.StateRepo;
import com.model.StateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type State service.
 */
@Service
public class StateService {
    @Autowired
    private StateRepo stateRepo;


    /**
     * List all states list.
     *
     * @return the list
     */
    public List<StateModel> listAllStates() {

        return stateRepo.findAll();
    }

}
