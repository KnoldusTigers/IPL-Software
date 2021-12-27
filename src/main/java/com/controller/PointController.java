package com.controller;

import com.model.PointModel;
import com.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * The type Point controller.
 */

@Controller
public class PointController {

   public PointController() {
       // default constructor
   }
       @Autowired
       private ResultService resultservic;

    /**
     * View home string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/")
    public String viewHome(final Model model) {

        final List<PointModel> pointlist = resultservic.getPoint();

        model.addAttribute("pointlist", pointlist);

        return "index";
    }

}
