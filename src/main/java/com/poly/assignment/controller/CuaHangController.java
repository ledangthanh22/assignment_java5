package com.poly.assignment.controller;

import com.poly.assignment.entity.CuaHang;
import com.poly.assignment.service.CuaHangService;
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
@RequestMapping("/cua-hang/")
public class CuaHangController {

    @Autowired
    private CuaHangService cuaHangService;

    @GetMapping("show")
    public String showList(@RequestParam(value = "page", defaultValue = "0") Integer pageNo, Model model) {
        Page<CuaHang> page = cuaHangService.findPaginated(pageNo, 4);
        model.addAttribute("listShops", page.getContent());

        model.addAttribute("currentPage", page.getNumber());
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("view", "/WEB-INF/view/admin/cuahang/index.jsp");
        return "layout/index";
    }

    @GetMapping("new")
    public String showNewForm(Model model) {
        model.addAttribute("shop", new CuaHang());
        model.addAttribute("view", "/WEB-INF/view/admin/cuahang/new-cuahang.jsp");
        return "layout/index";
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("shop", new CuaHang());
        model.addAttribute("shop", cuaHangService.getOne(UUID.fromString(id)));
        model.addAttribute("view", "/WEB-INF/view/admin/cuahang/update-cuahang.jsp");
        return "layout/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        cuaHangService.delete(UUID.fromString(id));
        return "redirect:/cua-hang/show";
    }

    @PostMapping("save")
    public String save(@Valid @ModelAttribute("shop") CuaHang shop, BindingResult result,Model model) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/WEB-INF/view/admin/cuahang/new-cuahang.jsp");
            return "layout/index";
        }
        cuaHangService.save(shop);
        return "redirect:/cua-hang/show";
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("shop") CuaHang shop, BindingResult result,Model model) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/WEB-INF/view/admin/cuahang/update-cuahang.jsp");
            return "layout/index";
        }
        cuaHangService.save(shop);
        return "redirect:/cua-hang/show";
    }

}
