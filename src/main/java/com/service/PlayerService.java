package com.service;

import com.dao.PlayerRepo;
import com.model.PlayersModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * The type Player service.
 */
@Service
public class PlayerService {
    @Autowired
    private PlayerRepo prepo;

    /**
     * Save.
     *
     * @param player_model the player model
     */
    public void save(final PlayersModel player_model) {

        prepo.save(player_model);
    }

    /**
     * Get players model.
     *
     * @param Id the id
     * @return the players model
     */
    public PlayersModel get(String Id) {

        return prepo.findById(Integer.valueOf(Id)).get();
    }

    /**
     * Find by playersplayer name optional.
     *
     * @param playername the playername
     * @return the optional
     */
    @Transactional
    public Optional<PlayersModel> findByPlayersplayer_name(String playername) {
        return prepo.findByName(playername);
    }

    /**
     * Playername exists boolean.
     *
     * @param playername the playername
     * @return the boolean
     */
    public boolean playernameExists(String playername) {
        return findByPlayersplayer_name(playername).isPresent();
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(int id) {

        prepo.deleteById(id);
    }

}


