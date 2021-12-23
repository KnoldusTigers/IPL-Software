package com.controller;
import com.model.Login;
import com.service.Loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.Objects;

/**
 * The type Login controller.
 */
@Controller
public class LoginController {

    @Autowired
    private Loginservice userService;

    /**
     * Instantiates a new Login controller.
     *
     * @param userService the user service
     */
    public LoginController(Loginservice userService) {
        this.userService = userService;
    }

    /**
     * Login model and view.
     *
     * @return the model and view
     */
    @GetMapping("/login")

    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new Login());
        return mav;
    }

    /**
     * Login string.
     *
     * @param user   the user
     * @param result the result
     * @return the string
     */
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("user") final Login user, BindingResult result) {

        Login loginUser = userService.login(user.getUsername(), user.getPassword());

        if (Objects.nonNull(loginUser)) {

            return "redirect:/Admin";


        } else {

            return "redirect:/login";


        }
    }
}


