package com.exampleHomeworklibraries1.controller;

import com.exampleHomeworklibraries1.service.Employee;
import com.exampleHomeworklibraries1.service.NewEmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class NewEmployeeController {
    private final NewEmployeeService newEmployeeService;

    public NewEmployeeController(NewEmployeeService newEmployeeService) {
        this.newEmployeeService = newEmployeeService;
    }

    @GetMapping("/max-salary")
    public Employee employeeMaxSalary(@RequestParam("department") int department) {
        return newEmployeeService.maxSalaryFromMap(department);
    }

    @GetMapping("/min-salary")
    public Employee employeeMinSalary(@RequestParam("department") int department) {
        return newEmployeeService.minSalary(department);
    }

    @GetMapping(value = "/all", params = "department")
    public List<Employee> employeeByDepartment(@RequestParam("department") int department){
        return newEmployeeService.allEmployees(department);
    }

    @GetMapping("all")
    public Map<Integer, List<Employee>> allEmployees(){
        return newEmployeeService.all();
    }

}
