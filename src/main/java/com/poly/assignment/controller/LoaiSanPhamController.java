package com.poly.assignment.controller;

import com.poly.assignment.entity.LoaiSanPham;
import com.poly.assignment.service.LoaiSanPhamService;
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
@RequestMapping("/loai-san-pham/")
public class LoaiSanPhamController {

    @Autowired
    private LoaiSanPhamService loaiSanPhamService;

    @GetMapping("show")
    public String showList(@RequestParam(name = "page", defaultValue = "0") Integer pageNo, Model model) {

        Page<LoaiSanPham> page = loaiSanPhamService.findPaginated(pageNo, 4);

        model.addAttribute("listCategories", page.getContent());
        model.addAttribute("currentPage", page.getNumber());
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("view", "/WEB-INF/view/admin/loaisanpham/index.jsp");
        return "layout/index";
    }

    @GetMapping("new")
    public String showNewForm(Model model) {
        model.addAttribute("category", new LoaiSanPham());
        model.addAttribute("view", "/WEB-INF/view/admin/loaisanpham/new-loaisanpham.jsp");
        return "layout/index";
    }

    @GetMapping("edit/{id}")
    public String showNewForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("category", new LoaiSanPham());
        model.addAttribute("category", loaiSanPhamService.getOne(UUID.fromString(id)));

        model.addAttribute("view", "/WEB-INF/view/admin/loaisanpham/update-loaisanpham.jsp");
        return "layout/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        loaiSanPhamService.delete(UUID.fromString(id));
        return "redirect:/loai-san-pham/show";
    }

    @PostMapping("save")
    public String save(@Valid @ModelAttribute("category") LoaiSanPham category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/WEB-INF/view/admin/loaisanpham/new-loaisanpham.jsp");
            return "layout/index";
        }
        loaiSanPhamService.save(category);
        return "redirect:/loai-san-pham/show";
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("category") LoaiSanPham category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/WEB-INF/view/admin/loaisanpham/update-loaisanpham.jsp");
            return "layout/index";
        }
        loaiSanPhamService.save(category);
        return "redirect:/loai-san-pham/show";
    }
}
