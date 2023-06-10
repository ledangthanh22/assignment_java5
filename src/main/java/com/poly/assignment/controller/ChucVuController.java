package com.poly.assignment.controller;

import com.poly.assignment.entity.ChucVu;
import com.poly.assignment.service.ChucVuService;
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
@RequestMapping("/chuc-vu/")
public class ChucVuController {

    @Autowired
    private ChucVuService chucVuService;

    @GetMapping("show")
    public String showList(@RequestParam(name = "page",defaultValue = "0") Integer pageNo, Model model){

        Page<ChucVu> page = chucVuService.findPaginated(pageNo,4);

        model.addAttribute("listPositions",page.getContent());
        model.addAttribute("currentPage",page.getNumber());
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("view","/WEB-INF/view/admin/chucvu/index.jsp");
        return "layout/index";
    }

    @GetMapping("new")
    public String showNewForm(Model model){
        model.addAttribute("position",new ChucVu());
        model.addAttribute("view","/WEB-INF/view/admin/chucvu/new-chucvu.jsp");
        return "layout/index";
    }

    @GetMapping("edit/{id}")
    public String showNewForm(@PathVariable("id") String id, Model model){
        model.addAttribute("position",new ChucVu());
        model.addAttribute("position",chucVuService.getOne(UUID.fromString(id)));
        model.addAttribute("view","/WEB-INF/view/admin/chucvu/update-chucvu.jsp");
        return "layout/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id, Model model){
        chucVuService.delete(UUID.fromString(id));
        return "redirect:/chuc-vu/show";
    }

    @PostMapping("save")
    public String save(@Valid @ModelAttribute("position") ChucVu position, BindingResult result,Model model){
        if (result.hasErrors()){
            model.addAttribute("view","/WEB-INF/view/admin/chucvu/new-chucvu.jsp");
            return "layout/index";
        }
        chucVuService.save(position);
        return "redirect:/chuc-vu/show";
    }
    @PostMapping("update")
    public String update(@Valid @ModelAttribute("position") ChucVu position, BindingResult result,Model model){
        if (result.hasErrors()){
            model.addAttribute("view","/WEB-INF/view/admin/chucvu/update-chucvu.jsp");
            return "layout/index";
        }
        chucVuService.save(position);
        return "redirect:/chuc-vu/show";
    }
}
