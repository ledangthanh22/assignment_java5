package com.poly.assignment.controller;

import com.poly.assignment.entity.SanPhamCT;
import com.poly.assignment.service.LoaiSanPhamService;
import com.poly.assignment.service.MauSacService;
import com.poly.assignment.service.SanPhamCTService;
import com.poly.assignment.service.SanPhamService;
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
@RequestMapping("/san-pham-chi-tiet/")
public class SanPhamCTController {

    @Autowired
    private SanPhamCTService sanPhamCTService;

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private MauSacService mauSacService;

    @Autowired
    private ThuongHieuService thuongHieuService;

    @Autowired
    private LoaiSanPhamService loaiSanPhamService;

    @GetMapping("show")
    public String showList(@RequestParam(value = "page", defaultValue = "0") Integer pageNo, Model model) {
        Page<SanPhamCT> page = sanPhamCTService.findPaginated(pageNo, 4);

        model.addAttribute("listDetailProducts", page.getContent());
        model.addAttribute("currentPage", page.getNumber());
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("view", "/WEB-INF/view/admin/sanphamchitiet/index.jsp");
        return "layout/index";
    }

    @GetMapping("new")
    public String showNewForm(Model model) {
        model.addAttribute("detailProduct", new SanPhamCT());
        model.addAttribute("listProducts", sanPhamService.getAll());
        model.addAttribute("listCategories", loaiSanPhamService.getAll());
        model.addAttribute("listColors", mauSacService.getAll());
        model.addAttribute("listPositions", thuongHieuService.getAll());

        model.addAttribute("view", "/WEB-INF/view/admin/sanphamchitiet/new-sanphamchitiet.jsp");
        return "layout/index";
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {

        model.addAttribute("detailProduct", new SanPhamCT());

        model.addAttribute("detailProduct", sanPhamCTService.getOne(UUID.fromString(id)));

        model.addAttribute("listProducts", sanPhamService.getAll());
        model.addAttribute("listCategories", loaiSanPhamService.getAll());
        model.addAttribute("listColors", mauSacService.getAll());
        model.addAttribute("listPositions", thuongHieuService.getAll());

        model.addAttribute("view", "/WEB-INF/view/admin/sanphamchitiet/update-sanphamchitiet.jsp");
        return "layout/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        sanPhamCTService.delete(UUID.fromString(id));
        return "redirect:/san-pham-chi-tiet/show";
    }

    @PostMapping("save")
    public String save(@Valid @ModelAttribute("detailProduct") SanPhamCT detailProduct, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listProducts", sanPhamService.getAll());
            model.addAttribute("listCategories", loaiSanPhamService.getAll());
            model.addAttribute("listColors", mauSacService.getAll());
            model.addAttribute("listPositions", thuongHieuService.getAll());
            model.addAttribute("view", "/WEB-INF/view/admin/sanphamchitiet/new-sanphamchitiet.jsp");
            return "layout/index";
        }
        sanPhamCTService.save(detailProduct);
        return "redirect:/san-pham-chi-tiet/show";
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("detailProduct") SanPhamCT detailProduct, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listProducts", sanPhamService.getAll());
            model.addAttribute("listCategories", loaiSanPhamService.getAll());
            model.addAttribute("listColors", mauSacService.getAll());
            model.addAttribute("listPositions", thuongHieuService.getAll());
            model.addAttribute("view", "/WEB-INF/view/admin/sanphamchitiet/update-sanphamchitiet.jsp");
            return "layout/index";
        }
        sanPhamCTService.save(detailProduct);
        return "redirect:/san-pham-chi-tiet/show";
    }
}
