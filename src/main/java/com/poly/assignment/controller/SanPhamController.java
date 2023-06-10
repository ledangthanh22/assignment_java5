package com.poly.assignment.controller;

import com.poly.assignment.entity.SanPham;
import com.poly.assignment.service.SanPhamService;
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
@RequestMapping("/san-pham/")
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("show")
    public String showList(@RequestParam(name = "page", defaultValue = "0") Integer pageNo, Model model) {
        Page<SanPham> page = sanPhamService.findPaginated(pageNo, 4);

        model.addAttribute("listProducts", page.getContent());
        model.addAttribute("currentPage", page.getNumber());
        model.addAttribute("totalPages", page.getTotalPages());

        model.addAttribute("view", "/WEB-INF/view/admin/sanpham/index.jsp");
        return "layout/index";
    }

    @GetMapping("new")
    public String showNewForm(Model model) {
        model.addAttribute("product", new SanPham());
        model.addAttribute("view", "/WEB-INF/view/admin/sanpham/new-sanpham.jsp");
        return "layout/index";
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("product", new SanPham());
        model.addAttribute("product", sanPhamService.getOne(UUID.fromString(id)));

        model.addAttribute("view", "/WEB-INF/view/admin/sanpham/update-sanpham.jsp");
        return "layout/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        sanPhamService.delete(UUID.fromString(id));
        return "redirect:/san-pham/show";
    }

    @PostMapping("save")
    public String save(@Valid @ModelAttribute("product") SanPham product, BindingResult result,Model model) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/WEB-INF/view/admin/sanpham/new-sanpham.jsp");
            return "layout/index";
        }
        sanPhamService.save(product);
        return "redirect:/san-pham/show";

    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("product") SanPham product, BindingResult result,Model model) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/WEB-INF/view/admin/sanpham/update-sanpham.jsp");
            return "layout/index";
        }
        sanPhamService.save(product);
        return "redirect:/san-pham/show";

    }
}
