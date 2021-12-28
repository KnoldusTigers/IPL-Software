package com.controller;
import com.dao.TeamRepo;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;


/**
 * The type Player controller.
 */
@Controller
public class PlayerController {

    @Autowired
    private final PlayerService playerservice;
    @Autowired
    private final TeamService teamservice;
    @Autowired
    private final PlayerRepo playerRepo;
    @Autowired
    private final TeamRepo teamRepo;

    /**
     * Instantiates a new Player controller.
     *
     * @param playerservice the playerservice
     * @param teamservice   the teamservice
     * @param playerRepo    the player repo
     * @param teamRepo      the team repo
     */
    public PlayerController(PlayerService playerservice, TeamService teamservice, PlayerRepo playerRepo, TeamRepo teamRepo) {
        this.playerservice = playerservice;
        this.teamservice = teamservice;
        this.playerRepo = playerRepo;
        this.teamRepo = teamRepo;
    }

    /**
     * Add string.
     *
     * @param model the model
     * @return the string
     */
//open add new players page
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
     * @param playersModelObj the pm
     * @param result          the result
     * @return the string
     */
//save player in database and check validations before save
    @RequestMapping(value = "/Save", method = RequestMethod.POST)
    public String savePlayer(@Valid @ModelAttribute("Player") final PlayersModel playersModelObj, BindingResult result, RedirectAttributes redirectAttributes) {
        if (playerservice.playernameExists(String.valueOf(playersModelObj.getName()))) {

            result.addError(new FieldError("playersModelObj", "name", "Player name already exists"));
        }
        if (result.hasErrors()) {

             return "addPlayers";

        }

            if (teamRepo.findById(playersModelObj.getTeam().getId()).get().getPlayersModel().size() < 5) {
                playerservice.save(playersModelObj);
                redirectAttributes.addFlashAttribute("Addmessage", "Player Added successfully");
                redirectAttributes.addFlashAttribute("messageType", "player");
                redirectAttributes.addFlashAttribute("alertType", "success");
            }
            else{
                redirectAttributes.addFlashAttribute("message", "Players can not be more than 5");
                redirectAttributes.addFlashAttribute("messageType", "player");
                redirectAttributes.addFlashAttribute("alertType", "error");
                return "redirect:addPlayers";
            }
            return "redirect:editPlayers";

        }


    /**
     * Update player string.
     *
     * @param playersModelObj the players model obj
     * @param result          the result
     * @return the string
     */
    @RequestMapping(value = "/UpdatePlayers", method = RequestMethod.POST)
    public String updatePlayer(@Valid @ModelAttribute("Player") final PlayersModel playersModelObj, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
             return "updatePlayer";

        }
        else {
            playerservice.save(playersModelObj);
            redirectAttributes.addFlashAttribute("Updatemessage", "Player Updated successfully");
            redirectAttributes.addFlashAttribute("messageType", "player");
            redirectAttributes.addFlashAttribute("alertType", "success");
            return "redirect:editPlayers";

        }
    }

    /**
     * View teams string.
     *
     * @param team_id the team id
     * @param model   the model
     * @return the string
     */
//show players of particular team
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
//show all players
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
//open edit player page
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
//edit player by id
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
    public String deletestudent(@PathVariable(name = "id") int id, RedirectAttributes redirectAttributes) {
        playerservice.delete(id);
         redirectAttributes.addFlashAttribute("deletemessage", "Player Deleted successfully");
         redirectAttributes.addFlashAttribute("messageType", "player");
         redirectAttributes.addFlashAttribute("alertType", "success");
         return "redirect:/editPlayers";
    }
}


