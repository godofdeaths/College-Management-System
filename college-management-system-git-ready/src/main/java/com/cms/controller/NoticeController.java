package com.cms.controller;

import com.cms.model.Notice;
import com.cms.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/notices")
public class NoticeController {
    @Autowired
    private NoticeRepository noticeRepository;

    private boolean auth(HttpSession session){ return session.getAttribute("user")!=null; }

    @GetMapping("/")
    public String list(Model model, HttpSession session){
        if(!auth(session)) return "redirect:/login";
        model.addAttribute("notices", noticeRepository.findAll());
        return "notices/list";
    }

    @GetMapping("/add")
    public String addForm(Model model, HttpSession session){
        if(!auth(session)) return "redirect:/login";
        model.addAttribute("notice", new Notice());
        return "notices/add";
    }

    @PostMapping("/add")
    public String add(Notice notice){
        noticeRepository.save(notice);
        return "redirect:/notices/";
    }
}
