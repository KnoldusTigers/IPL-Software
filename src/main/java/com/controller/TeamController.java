package com.controller;
import com.model.TeamModel;
import com.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


/**
 * The type Team controller.
 */
@Controller
public class TeamController {
    @Autowired
    private final TeamService service;


    /**
     * Instantiates a new Team controller.
     *
     * @param service the service
     */
    public TeamController(final TeamService service) {
        this.service = service;
    }

    /**
     * Add string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping(value = "/addTeam")
    public String add(final Model model) {
        model.addAttribute("Team", new TeamModel());
        return "addTeam";
    }

    /**
     * Save team string.
     *
     * @param teamModel     the tm
     * @param result the result
     * @return the string
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTeam(final @Valid @ModelAttribute("Team") TeamModel teamModel, final BindingResult result) {
        if (service.teamNameExists(teamModel.getTeamname())) {
            result.addError(new FieldError("pm", "teamname", "name already exists"));
        }
        String redirect;
        if (result.hasErrors()) {
            redirect= "addTeam";
        } else {
            service.saveTeams(teamModel);
            redirect=  "redirect:Admin";
        }
        return  redirect;

    }

    /**
     * View teams page string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/Teams")
    public String viewTeamsPage(final Model model) {
        final List<TeamModel> teamList = service.listAll();
        model.addAttribute("teamList", teamList);
        return "Teams";
    }

    /**
     * View teams 1 string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/Admin")
    public String viewTeams1(final Model model) {
        final List<TeamModel> teamList = service.listAll();
        model.addAttribute("teamList", teamList);

        return "Admin";
    }

}
