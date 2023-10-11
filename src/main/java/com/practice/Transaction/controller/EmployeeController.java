package com.practice.Transaction.controller;

import com.practice.Transaction.service.EmployeeService;
import com.practice.Transaction.vo.EmployeeRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public String saveEmployee(@RequestBody EmployeeRequestVO employeeRequestVO) {
        return employeeService.saveEmployee(employeeRequestVO);
    }
}
