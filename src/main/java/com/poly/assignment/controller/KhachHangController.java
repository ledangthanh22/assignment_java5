package com.poly.assignment.controller;

import com.poly.assignment.entity.KhachHang;
import com.poly.assignment.service.KhachHangService;
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
@RequestMapping("/khach-hang/")
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("show")
    public String showList(@RequestParam(name = "page", defaultValue = "0") Integer pageNo, Model model) {

        Page<KhachHang> page = khachHangService.findPaginated(pageNo, 4);

        model.addAttribute("listCustomers", page.getContent());
        model.addAttribute("currentPage", page.getNumber());
        model.addAttribute("totalPages", page.getTotalPages());

        model.addAttribute("view", "/WEB-INF/view/admin/khachhang/index.jsp");
        return "layout/index";
    }

    @GetMapping("new")
    public String showNewForm(Model model) {
        model.addAttribute("customer", new KhachHang());

        model.addAttribute("view", "/WEB-INF/view/admin/khachhang/new-khachhang.jsp");
        return "layout/index";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("customer", new KhachHang());
        model.addAttribute("customer", khachHangService.getOne(UUID.fromString(id)));

        model.addAttribute("view", "/WEB-INF/view/admin/khachhang/update-khachhang.jsp");
        return "layout/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        khachHangService.delete(UUID.fromString(id));
        return "redirect:/khach-hang/show";
    }

    @PostMapping("save")
    public String save(@Valid @ModelAttribute("customer") KhachHang customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/WEB-INF/view/admin/khachhang/new-khachhang.jsp");
            return "layout/index";
        }

        khachHangService.save(customer);
        return "redirect:/khach-hang/show";
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("customer") KhachHang customer, BindingResult result,Model model) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/WEB-INF/view/admin/khachhang/update-khachhang.jsp");
            return "layout/index";
        }
        khachHangService.save(customer);
        return "redirect:/khach-hang/show";
    }
}
