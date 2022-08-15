package com.example.demo.services.employee;

import com.example.demo.common.enums.EnumException;
import com.example.demo.common.exceptions.DemoException;
import com.example.demo.entity.Employee;
import com.example.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void createEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> e = employeeRepository.findById(id);
        Employee employee = null;
        if (e.isPresent()) {
            employee = e.get();
        } else {
            throw new DemoException(EnumException.EMPLOYEE_NOT_EXIST);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        if (getEmployeeById(id) == null) {
            throw new DemoException(EnumException.EMPLOYEE_NOT_EXIST);
        }
        this.employeeRepository.deleteById(id);
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        boolean equals = getEmployeeById(id).getId().equals(employee.getId());
        Employee employeeById = getEmployeeById(id);
        if (employeeById == null || !equals) {
            throw new DemoException(EnumException.EMPLOYEE_NOT_EXIST);
        }
        Employee employeeUpdate = getEmployeeById(employee.getId());
        employeeUpdate.setName(employee.getName());
        employeeUpdate.setAddress(employee.getAddress());
        employeeUpdate.setEmail(employee.getEmail());
        employeeUpdate.setNote(employee.getNote());
        employeeUpdate.setRoleId(employee.getRoleId());
        employeeUpdate.setDepartmentId(employeeUpdate.getDepartmentId());
        employeeRepository.save(employeeUpdate);
    }

    @Override
    public Page<Employee> findPagination(int pageNumber, int pageSize, String softField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(softField).ascending() : Sort.by(softField).descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        return this.employeeRepository.findAll(pageable);
    }
}
