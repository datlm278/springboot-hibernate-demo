package com.example.demo.controllers;

import com.example.demo.common.constants.DemoConstant;
import com.example.demo.entity.Employee;
import com.example.demo.services.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(DemoConstant.REST_URL + "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/find-all")
    public ResponseEntity<List<Employee>> findAllEmployee() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

//    @GetMapping(value = "/page")
//    public ResponseEntity<Page<Employee>> findAllEmployeeByPage(@RequestParam(name = "pageNumber") int pageNumber, @RequestParam(name = "pageSize") int pageSize,
//                                                                @RequestParam(name = "sortStatus") String sortStatus, @RequestParam(name = "sortDirection") String sortDirection) {
//        Page<Employee> employees = employeeService.findPagination(pageNumber, pageSize, sortStatus, sortDirection);
//        return ResponseEntity.ok(employees);
//    }

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return ResponseEntity.ok().body("Create employee successfully!");
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable(name = "id") Long id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok().body("Update employee successfully!");
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(name = "id") Long id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok().body("Delete employee successfully!");
    }
}
