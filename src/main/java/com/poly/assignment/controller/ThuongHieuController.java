package com.poly.assignment.controller;

import com.poly.assignment.entity.ThuongHieu;
import com.poly.assignment.service.ThuongHieuService;
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
@RequestMapping("/thuong-hieu/")
public class ThuongHieuController {
    @Autowired
    private ThuongHieuService thuongHieuService;

    @GetMapping("show")
    public String showList(@RequestParam(name = "page", defaultValue = "0") Integer pageNo, Model model) {

        Page<ThuongHieu> page = thuongHieuService.findPaginated(pageNo, 4);

        model.addAttribute("listBrands", page.getContent());
        model.addAttribute("currentPage", page.getNumber());
        model.addAttribute("totalPages", page.getTotalPages());

        model.addAttribute("view", "/WEB-INF/view/admin/thuonghieu/index.jsp");
        return "layout/index";
    }

    @GetMapping("new")
    public String showNewForm(Model model) {
        model.addAttribute("brand", new ThuongHieu());
        model.addAttribute("view", "/WEB-INF/view/admin/thuonghieu/new-thuonghieu.jsp");
        return "layout/index";
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("brand", new ThuongHieu());
        model.addAttribute("brand", thuongHieuService.getOne(UUID.fromString(id)));
        model.addAttribute("view", "/WEB-INF/view/admin/thuonghieu/update-thuonghieu.jsp");
        return "layout/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        thuongHieuService.delete(UUID.fromString(id));
        return "redirect:/thuong-hieu/show";
    }

    @PostMapping("save")
    public String save(@Valid @ModelAttribute("brand") ThuongHieu brand, BindingResult result,Model model) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/WEB-INF/view/admin/thuonghieu/new-thuonghieu.jsp");
            return "layout/index";
        }
        thuongHieuService.save(brand);
        return "redirect:/thuong-hieu/show";
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("brand") ThuongHieu brand, BindingResult result,Model model) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/WEB-INF/view/admin/thuonghieu/update-thuonghieu.jsp");
            return "layout/index";
        }
        thuongHieuService.save(brand);
        return "redirect:/thuong-hieu/show";
    }
}
