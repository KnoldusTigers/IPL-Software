package com.controller;



import com.model.MatchModel;
import com.model.StateModel;
import com.model.TeamModel;
import com.service.MatchService;
import com.service.ResultService;
import com.service.StateService;
import com.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * The type Match controller.
 */
@Controller
public class MatchController {

    /**
     *
     */
    @Autowired
    private final ResultService reservice;
    /**
     *
     */
    @Autowired
    private final MatchService matchService;
    /**
     *
     */
    @Autowired
    private final TeamService teamService;
    /**
     *
     */
    @Autowired
    private final StateService stateService;

    /**
     * Instantiates a new Match controller.
     *
     * @param reservice    the reservice
     * @param matchService the match service
     * @param teamService  the team service
     * @param stateService the state service
     */
    public MatchController(ResultService reservice, MatchService matchService, TeamService teamService, StateService stateService) {
        this.reservice = reservice;
        this.matchService = matchService;
        this.teamService = teamService;
        this.stateService = stateService;
    }

    /**
     * View match string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping(value = "/viewMatch")
    public String viewMatch(final Model model) {
        List<MatchModel> matchModelsList = matchService.getAllMatches();
        model.addAttribute("matchModelsList", matchModelsList);
        List<StateModel> stateList = stateService.listAllStates();
        model.addAttribute("stateList", stateList);
        return "viewMatch";
    }

    /**
     * Add match string.
     *
     * @param model the model
     * @return the string
     */
//return match scheduling page
    @GetMapping(value = "/matchSchedule")
    public String addMatch(final Model model) {
        model.addAttribute("match", new MatchModel());
        List<TeamModel> teamList = teamService.listAll();
        model.addAttribute("teamList", teamList);
        List<StateModel> stateList = stateService.listAllStates();
        model.addAttribute("stateList", stateList);
        return "matchSchedule";
    }

    /**
     * Save match string.
     *
     * @param match  the match
     * @param result the result
     * @return the string
     */
//Save a scheduled match and return veiw match page
    @RequestMapping(value = "/SaveMatch", method = RequestMethod.POST)
    final String saveMatch(@Valid @ModelAttribute("match") MatchModel match, final BindingResult result) {
        if (matchService.DateIsExist(match.getScheduledate(), result) && matchService.teamIsExist(match.getTeam1(), result) || matchService.teamIsExist(match.getTeam2(), result)) {
            result.addError(new FieldError("match", "team1", "team1 or team2 match already scheduled"));
        }

        else if (matchService.venueExists(match.getVenue(), result) && matchService.DateIsExist(match.getScheduledate(), result)) {
            System.out.println((match.getScheduledate())  + "+++++++++++++++++++++++controller");
            result.addError(new FieldError("match", "scheduledate", "date or venue already exists"));
        }

        if (result.hasErrors()) {

            return "matchSchedule";
        }
        else {

            matchService.save(match);
            return "redirect:viewMatch";
        }

    }

    /**
     * Update mtch string.
     *
     * @param match  the match
     * @param result the result
     * @return the string
     */
    @RequestMapping(value = "/upMatch", method = RequestMethod.POST)
    public String updateMtch(@Valid @ModelAttribute("match") MatchModel match, final BindingResult result) {
//        if (matchService.DateIsExist(match.getScheduledate(), result) && matchService.teamIsExist(match.getTeam1(), result)) {
//            result.addError(new FieldError("match", "team1", "team1 or team2 match already scheduled"));
//        }
        if (matchService.venueExists(match.getVenue(), result) && matchService.DateIsExist(match.getScheduledate(), result)) {
            System.out.println((match.getScheduledate())  + "+++++++++++++++++++++++controller");
            result.addError(new FieldError("match", "scheduledate", "date or venue already exists"));
        }


        if (result.hasErrors()) {

            return "updateMatch";
        }
        else {

            matchService.save(match);
            return "redirect:viewMatch";
        }
    }

    /**
     * Updatescore string.
     *
     * @param match  the match
     * @param result the result
     * @return the string
     */
    @RequestMapping(value = "/SaveScore", method = RequestMethod.POST)
    public String updatescore(@Valid @ModelAttribute("match") MatchModel match, final BindingResult result) {

        if (match.getTeam1Overs() * 6 * 6 <= Double.parseDouble(match.getTeam1Description())) {
            System.out.println("++_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+team1");

            result.addError(new FieldError("match", "Team1Description", "runs is not greater then balls"));

        }

        if (match.getTeam2Overs() * 6 * 6 <= Double.parseDouble(match.getTeam2Description())) {
            System.out.println("++_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_hellooooooo");

            result.addError(new FieldError("match", "Team2Description", "runs is not greater then balls"));

        }
        if (result.hasErrors()) {
            System.out.println("++_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_");
            return "UpdateScore";
        } else {
            match = reservice.getResult(match);
            matchService.save(match);
            return "redirect:EditListScore";
        }
    }

    /**
     * View score string.
     *
     * @param model the model
     * @return the string
     */
//
    @GetMapping(value = "/UpdateScore")
    public String viewScore(final Model model) {
        List<MatchModel> matchModelsList = matchService.getAllMatches();
        model.addAttribute("matchModelsList", matchModelsList);
        return "UpdateScore";
    }

    /**
     * Edit score string.
     *
     * @param model the model
     * @return the string
     */
// edit score List
    @GetMapping(value = "/EditListScore")
    public String editScore(final Model model) {
        List<MatchModel> matchModelsList = matchService.getAllMatches();
        model.addAttribute("matchModelsList", matchModelsList);

        return "EditListScore";
    }

    /**
     * Show edit score model and view.
     *
     * @param id the id
     * @return the model and view
     */
    @RequestMapping("/editScore/{matchid}")
    public ModelAndView showEditScore(@PathVariable(name = "matchid") final String id) {
        ModelAndView modelAndView = new ModelAndView("UpdateScore");
        MatchModel matchModel = matchService.get(Integer.parseInt((id)));
        modelAndView.addObject("match", matchModel);

        List<TeamModel> teamList = teamService.listAll();
        modelAndView.addObject("teamList", teamList);

        return modelAndView;
    }

    /**
     * Show edit pllayer model and view.
     *
     * @param id the id
     * @return the model and view
     */
//edit a match
    @RequestMapping("/editmatch/{matchid}")
    public ModelAndView showEditPllayer(@PathVariable(name = "matchid") final String id) {
        ModelAndView modelAndView = new ModelAndView("updateMatch");
        MatchModel matchModel = matchService.get(Integer.parseInt((id)));
        modelAndView.addObject("match", matchModel);

        List<TeamModel> teamList = teamService.listAll();
        modelAndView.addObject("teamList", teamList);
        List<StateModel> stateList = stateService.listAllStates();
        modelAndView.addObject("stateList", stateList);

        return modelAndView;
    }

    /**
     * Deletestudent string.
     *
     * @param id the id
     * @return the string
     */
//delete a match
    @RequestMapping("/deletematch/{matchid}")
    public String deletestudent(@PathVariable(name = "matchid") final String id) {
        matchService.delete(Integer.parseInt(id));
        return "redirect:/editMatch";
    }

    /**
     * View match result string.
     *
     * @param model the model
     * @return the string
     */
//show result
    @GetMapping(value = "/result")
    public String viewMatchResult(final Model model) {
        List<MatchModel> matchModelsList = matchService.getAllMatches();
        model.addAttribute("matchModelsList", matchModelsList);
        return "result";
    }

    /**
     * Edit match string.
     *
     * @param model the model
     * @return the string
     */
//edit a match page
    @GetMapping(value = "/editMatch")
    public String editMatch(final Model model) {
        List<MatchModel> matchModelsList = matchService.getAllMatches();
        model.addAttribute("matchModelsList", matchModelsList);
        List<TeamModel> teamList = teamService.listAll();
        model.addAttribute("teamList", teamList);
        List<StateModel> stateList = stateService.listAllStates();
        model.addAttribute("stateList", stateList);
        return "editMatch";
    }

}
