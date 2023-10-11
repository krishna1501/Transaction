package com.practice.Transaction.service;

import com.practice.Transaction.entity.Department;
import com.practice.Transaction.entity.Employee;
import com.practice.Transaction.repository.DepartmentRepository;
import com.practice.Transaction.repository.EmployeeRepository;
import com.practice.Transaction.vo.EmployeeRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public String saveEmployee(EmployeeRequestVO employeeRequestVO) {
        Department department = new Department();
        department.setDepartmentCode(employeeRequestVO.getDepartmentName());
        department.setDepartmentCode(employeeRequestVO.getDepartmentCode());

        Long departmentId = departmentRepository.save(department).getDepartmentId();

        Employee employee = new Employee();
        employee.setEmpName(employeeRequestVO.getEmpName());
        employee.setEmail(employeeRequestVO.getEmail());
        employee.setDepartmentId(departmentId);

        employeeRepository.save(employee);

        return "Employee is saved with Employee ID : "+ employee.getEmployeeId();

    }
}
