package com.example.demo.services.employee;

import com.example.demo.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployees();
    void createEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    void deleteEmployeeById(Long id);
    void updateEmployee(Long id, Employee employee);
    Page<Employee> findPagination(int pageNumber, int pageSize, String softField, String sortDirection);
}
