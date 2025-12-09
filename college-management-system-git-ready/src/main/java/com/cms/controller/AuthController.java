package com.cms.controller;

import com.cms.model.User;
import com.cms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping({"/", "/login"})
    public String loginPage(){ return "login"; }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model){
        var userOpt = userRepository.findByUsername(username);
        if(userOpt.isPresent()){
            User user = userOpt.get();
            String stored = user.getPassword();
            // Accept either bcrypt-hashed password or plain text (for initial demo)
            boolean ok = false;
            try {
                ok = BCrypt.checkpw(password, stored);
            } catch(Exception ex){ /* not bcrypt */ }
            if(!ok && stored.equals(password)) ok = true;
            if(ok){
                session.setAttribute("user", user);
                return "redirect:/dashboard";
            }
        }
        model.addAttribute("error","Invalid credentials");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
}
