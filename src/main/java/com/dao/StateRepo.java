package com.dao;

import com.model.StateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface State repo.
 */
@Repository
public interface StateRepo extends JpaRepository<StateModel,Long> {
}
