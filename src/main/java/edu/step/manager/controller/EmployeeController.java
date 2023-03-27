package edu.step.manager.controller;

import edu.step.manager.model.Employee;
import edu.step.manager.model.EmployeeDTO;
import edu.step.manager.service.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// Serviciu REST
@RestController
@RequestMapping("/employees") // localhost:8080/employees
public class EmployeeController { /* MVC */

    @Autowired
    private EmployeeDao dao;

    // Metode: GET, POST, PUT, DELETE
    // GET /employees/filter?value= (List<Employee>)
    // GET /employees?name=John (List<Employee>)
    // POST /employee (CREATE) HTTP Request (Body)
    // PUT  /employee (UPDATE) HTTP Request (Body)
    // DELETE /employee?id=10

    // Create Read Update Delete

    // ResponseEntity

    // Get all - GET
    @GetMapping // GET localhost:8080/employees
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(dao.findAll());
    }

    @GetMapping("/{id}") // GET localhost:8080/employees/111
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/filter") // GET localhost:8080/employees/filter?name=Peter
    public ResponseEntity<Employee> getOne(@RequestParam String name) {
        if(name == null || name.trim().equals("")) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(dao.filter(name));
    }

    // Create - POST
    @PostMapping
    public ResponseEntity create(@RequestBody EmployeeDTO dto) {
        dao.create(dto.getName(), dto.getSurname(), dto.getBirthdate(), dto.getSalary());
        return ResponseEntity.ok().build();
    }

    // Update - PUT
    @PutMapping("/employee")
    public ResponseEntity update(@RequestParam Long id, @RequestBody EmployeeDTO dto){
        dao.update(id, dto.getName(), dto.getSurname(), dto.getBirthdate(), dto.getSalary());
        return ResponseEntity.ok().build();
    }

    // Delete - DELETE
    @DeleteMapping("/employee")
    public ResponseEntity delete(@RequestParam Long id) {
        dao.delete(id);
        return ResponseEntity.ok().build();
    }
}
