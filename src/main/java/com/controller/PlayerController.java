package com.controller;
import com.dao.TeamRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.dao.PlayerRepo;
import com.model.PlayersModel;
import com.model.TeamModel;
import com.service.PlayerService;
import com.service.TeamService;
import javax.validation.Valid;
import java.util.List;


/**
 * The type Player controller.
 */
@Controller
public class PlayerController {
    private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    private PlayerService playerservice;
    @Autowired
    private TeamService teamservice;
    @Autowired
    private TeamRepo teamRepo;

    /**
     * Add string.
     *
     * @param model the model
     * @return the string
     */
//add new players
    @GetMapping(value = "/addPlayers")
    public String add(Model model) {
        model.addAttribute("Player", new PlayersModel());
        List<TeamModel> teamList = teamservice.listAll();
        model.addAttribute("teamList", teamList);
        return "addPlayers";
    }

    /**
     * Save player string.
     *
     * @param playersModelObj the players model obj
     * @param result          the result
     * @return the string
     */
//save player
    @RequestMapping(value = "/Save", method = RequestMethod.POST)
    public String savePlayer(@Valid @ModelAttribute("Player") final PlayersModel playersModelObj, BindingResult result) {
        if(playerservice.playernameExists(String.valueOf(playersModelObj.getName()))){
            result.addError(new FieldError("pm","name","name already exists"));
        }
        if (result.hasErrors()) {
            logger.info("Validation errors while submitting form.");
            return "addPlayers";

        }
        else {
            if(teamRepo.findById(playersModelObj.getTeam().getId()).get().getPlayersModel().size()<15)
            {
                playerservice.save(playersModelObj);

            }
            return "redirect:addPlayers";

        }
    }

    @Autowired
    private PlayerRepo playerRepo;

    /**
     * View teams string.
     *
     * @param team_id the team id
     * @param model   the model
     * @return the string
     */
    @GetMapping(value = "/showPlayers/{team_id}")
    public String viewTeams(@PathVariable Long team_id, Model model) {
        List<PlayersModel> playerList =   playerRepo.findByTeamId(team_id);
        model.addAttribute("playerList",  playerList);

        return "showPlayers";
    }

    /**
     * Gets all players.
     *
     * @param model the model
     * @return the all players
     */
    @GetMapping(value = "/showPlayers")
    public String getAllPlayers(final Model model) {
        List<PlayersModel> playerList = (List<PlayersModel>) playerRepo.findAll();
        model.addAttribute("playerList",  playerList);

        return "showPlayers";
    }

    /**
     * Gets all players for edit.
     *
     * @param model the model
     * @return the all players for edit
     */
    @GetMapping(value = "/editPlayers")
    public String getAllPlayersForEdit(final Model model) {
        List<PlayersModel> playerList = (List<PlayersModel>) playerRepo.findAll();
        model.addAttribute("playerList",  playerList);
        List<TeamModel> teamList = teamservice.listAll();
        model.addAttribute("teamList", teamList);
        return "editPlayers";
    }

    /**
     * Show edit pllayer model and view.
     *
     * @param id the id
     * @return the model and view
     */
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPllayer(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("updatePlayer");
        PlayersModel playModel = playerservice.get(String.valueOf(id));
        modelAndView.addObject("Player", playModel);
        List<TeamModel> teamList = teamservice.listAll();
        modelAndView.addObject("teamList", teamList);
        return modelAndView;
    }

    /**
     * Deletestudent string.
     *
     * @param id the id
     * @return the string
     */
    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id") int id) {
        playerservice.delete(id);
        return "redirect:/editPlayers";
    }
}
