package com.service;

import com.dao.PlayerRepo;
import com.model.PlayersModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepo prepo;
    public void save(final PlayersModel player_model) {

        prepo.save(player_model);
    }
    public PlayersModel get(String Id) {

        return prepo.findById(Integer.valueOf(Id)).get();
    }
    @Transactional
    public Optional<PlayersModel> findByPlayersplayer_name(String playername) {
        return prepo.findByName(playername);
    }
    public boolean playernameExists(String playername){
        return findByPlayersplayer_name(playername).isPresent();
    }
    public void delete(int id) {

        prepo.deleteById(id);
    }

}


