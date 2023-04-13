package edu.step.manager.controller.web;
import edu.step.manager.model.EmployeeDTO;
import edu.step.manager.service.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AddController {
    @Autowired
    private EmployeeDao dao;

    @GetMapping("/add")
    public String addEmployee(Model model){
        EmployeeDTO employee=new EmployeeDTO();
        model.addAttribute("employee", employee);
        return "add";
    }


    @PostMapping("/add")
    public String create(@ModelAttribute (value = "employee") EmployeeDTO employee) {
        dao.create(employee.getName(), employee.getSurname(), employee.getBirthdate(), employee.getSalary());
        return "redirect:/";
    }
}
