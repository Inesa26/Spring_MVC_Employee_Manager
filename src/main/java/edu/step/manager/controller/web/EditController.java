package edu.step.manager.controller.web;

import edu.step.manager.model.Employee;
import edu.step.manager.model.EmployeeDTO;
import edu.step.manager.service.EmployeeDTOService;
import edu.step.manager.service.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EditController {
    @Autowired
    private EmployeeDao dao;

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") Long id,Model model){
        Employee employee =dao.findById(id);
        EmployeeDTO employeeDTO= EmployeeDTOService.convertToDTO(employee);
        model.addAttribute("employee", employee);
        return "edit";
    }


    @PostMapping ("/edit")
    public String editEmployee(@ModelAttribute (value = "employee") @RequestParam  Long id,  EmployeeDTO employee) {
        dao.update(id, employee.getName(), employee.getSurname(), employee.getBirthdate(), employee.getSalary());
        return "redirect:/";
    }

}
