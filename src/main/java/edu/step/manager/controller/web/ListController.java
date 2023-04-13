package edu.step.manager.controller.web;

import edu.step.manager.model.Employee;
import edu.step.manager.model.EmployeeDTO;
import edu.step.manager.repository.EmployeeRepository;
import edu.step.manager.service.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@Controller
public class ListController {

    @Autowired
    private EmployeeDao dao;

    @GetMapping("/list/{pageNo}")
    public String viewEmployees (@PathVariable("pageNo") int pageNo, Model model){
        int pageSize = 10;
        Page <Employee> page = dao.findPage(pageNo, pageSize);
        List<Employee> employeesList = page.getContent();
        model.addAttribute("page", pageNo);
        model.addAttribute("list", employeesList);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalEmployees", page.getTotalElements());
        return "list";
    }


}
