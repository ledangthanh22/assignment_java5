package com.poly.assignment.controller;

import com.poly.assignment.entity.NhanVien;
import com.poly.assignment.service.ChucVuService;
import com.poly.assignment.service.CuaHangService;
import com.poly.assignment.service.NhanVienService;
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
@RequestMapping("/nhan-vien/")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private ChucVuService chucVuService;

    @Autowired
    private CuaHangService cuaHangService;

    @GetMapping("show")
    public String showList(@RequestParam(name = "page", defaultValue = "0") Integer pageNo, Model model) {

        Page<NhanVien> page = nhanVienService.findPaginated(pageNo, 4);

        model.addAttribute("listStaffs", page.getContent());
        model.addAttribute("currentPage", page.getNumber());
        model.addAttribute("totalPages", page.getTotalPages());

        model.addAttribute("view", "/WEB-INF/view/admin/nhanvien/index.jsp");
        return "layout/index";
    }

    @GetMapping("new")
    public String showNewForm(Model model) {
        model.addAttribute("staff", new NhanVien());
        model.addAttribute("listShops", cuaHangService.getAll());
        model.addAttribute("listPositions", chucVuService.getAll());

        model.addAttribute("view", "/WEB-INF/view/admin/nhanvien/new-nhanvien.jsp");
        return "layout/index";
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("staff", new NhanVien());
        model.addAttribute("staff", nhanVienService.getOne(UUID.fromString(id)));
        model.addAttribute("listShops", cuaHangService.getAll());
        model.addAttribute("listPositions", chucVuService.getAll());

        model.addAttribute("view", "/WEB-INF/view/admin/nhanvien/update-nhanvien.jsp");
        return "layout/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        nhanVienService.delete(UUID.fromString(id));
        return "redirect:/nhan-vien/show";
    }

    @PostMapping("save")
    public String save(@Valid @ModelAttribute("staff") NhanVien staff, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listShops", cuaHangService.getAll());
            model.addAttribute("listPositions", chucVuService.getAll());
            model.addAttribute("view", "/WEB-INF/view/admin/nhanvien/new-nhanvien.jsp");
            return "layout/index";
        }
        nhanVienService.save(staff);
        return "redirect:/nhan-vien/show";
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("staff") NhanVien staff, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listShops", cuaHangService.getAll());
            model.addAttribute("listPositions", chucVuService.getAll());
            model.addAttribute("view", "/WEB-INF/view/admin/nhanvien/update-nhanvien.jsp");
            return "layout/index";
        }
        nhanVienService.save(staff);
        return "redirect:/nhan-vien/show";
    }
}
