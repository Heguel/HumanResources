package com.humanresources.api.controller;

import com.humanresources.api.model.Employee;
import com.humanresources.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/lists")
    public Iterable <Employee> getEmployees(){
        return employeeService.getEmployees();
    }
    @GetMapping("/{id}")
    public Optional<Employee> getEmployee(@PathVariable("id") @RequestBody Long id){
        return employeeService.getEmployee(id);
    }
    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return "Employee saved successfully";
    }
    @PutMapping("/{id}/edit")
    public String updateEmployee(@PathVariable("id") Long id,  @RequestBody Employee employee){
        employeeService.updateEmployee(id,employee);
        return "Updated successfully";
    }
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return "Deleted successfully";
    }
}
