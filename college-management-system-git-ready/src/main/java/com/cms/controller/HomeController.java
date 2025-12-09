package com.cms.controller;

import com.cms.model.User;
import com.cms.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    private NoticeRepository noticeRepository;

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model){
        User u = (User) session.getAttribute("user");
        if(u==null) return "redirect:/login";
        model.addAttribute("user", u);
        model.addAttribute("notices", noticeRepository.findAll());
        return "dashboard";
    }
}
