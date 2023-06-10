package com.poly.assignment.controller;

import com.poly.assignment.entity.MauSac;
import com.poly.assignment.service.MauSacService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/mau-sac/")
public class MauSacController {

    @Autowired
    private MauSacService mauSacService;

    @GetMapping("show")
    public String showList(@RequestParam(name = "page", defaultValue = "0") Integer pageNo, Model model) {
        Page<MauSac> page = mauSacService.findPaginated(pageNo, 4);

        model.addAttribute("listColors", page.getContent());
        model.addAttribute("currentPage", page.getNumber());
        model.addAttribute("totalPages", page.getTotalPages());

        model.addAttribute("view", "/WEB-INF/view/admin/mausac/index.jsp");
        return "layout/index";
    }

    @GetMapping("new")
    public String showNewForm(Model model) {
        model.addAttribute("color", new MauSac());
        model.addAttribute("view", "/WEB-INF/view/admin/mausac/new-mausac.jsp");
        return "layout/index";
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("color", new MauSac());
        model.addAttribute("color", mauSacService.getOne(UUID.fromString(id)));
        model.addAttribute("view", "/WEB-INF/view/admin/mausac/update-mausac.jsp");
        return "layout/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        mauSacService.delete(UUID.fromString(id));
        return "redirect:/mau-sac/show";
    }

    @PostMapping("save")
    public String save(@Valid @ModelAttribute("color") MauSac color, BindingResult result,Model model) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/WEB-INF/view/admin/mausac/new-mausac.jsp");
            return "layout/index";
        }
        mauSacService.save(color);
        return "redirect:/mau-sac/show";

    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("color") MauSac color, BindingResult result,Model model) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/WEB-INF/view/admin/mausac/update-mausac.jsp");
            return "layout/index";
        }
        mauSacService.save(color);
        return "redirect:/mau-sac/show";

    }
}
