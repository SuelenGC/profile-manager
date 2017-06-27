package com.suelengc.profile.manager.controller;

import com.suelengc.profile.manager.data.ProfileRepository;
import com.suelengc.profile.manager.model.Profile;
import com.suelengc.profile.manager.util.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ProfileController {
    public static final String ERROR_MESSAGE = "Profile não encontrado ou senha incorreta!";

    @Autowired
    private ProfileRepository userRepository;

    @RequestMapping("/login")
    public RedirectView login(@RequestParam String email, @RequestParam String password, RedirectAttributes attributes) {
        String encriptedPassword = new Encrypt().encode(password);
        Profile profile = userRepository.findByEmail(email);

        if (profile == null || !encriptedPassword.equals(profile.getPassword())) {
            attributes.addFlashAttribute("message", ERROR_MESSAGE);
            return new RedirectView("oops");
        }

        attributes.addFlashAttribute("profile", profile);
        return new RedirectView("home");
    }

    @RequestMapping("/oops")
    public String error(ModelMap model, @ModelAttribute("message") String errorMessage) {
        model.addAttribute("message", errorMessage);
        return "oops";
    }

    @RequestMapping("/home")
    public String home(ModelMap model, @ModelAttribute("profile") Profile profile) {
        model.addAttribute("profile", profile);
        return "home";
    }
}
