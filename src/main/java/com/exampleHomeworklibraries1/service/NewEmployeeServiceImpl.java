package com.exampleHomeworklibraries1.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class NewEmployeeServiceImpl implements NewEmployeeService {
    private final EmployeeServiceImpl employeeService;

    public NewEmployeeServiceImpl(EmployeeServiceImpl employeeService) {

        this.employeeService = employeeService;
    }

    @Override
    public Employee maxSalaryFromMap(int department) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == (department))
                .max(Comparator.comparing(employee -> employee.getSalary()))
                .orElseThrow(null);
    }

    @Override
    public Employee minSalary(int department) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == (department))
                .min(Comparator.comparing(employee -> employee.getSalary()))
                .orElseThrow(null);
    }

    @Override
    public List<Employee> allEmployees(int department) {
        return employeeService.getMap().values()
                .stream()
                .filter(e -> e.getDepartment() == (department))
                .collect(Collectors.toList());


    }

    @Override
    public Map<Integer, List<Employee>> all() {
        return employeeService.getAll()
                .stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment()));
    }

    //    public List<Employee> employees = new ArrayList<>(List.of(  Массив
//            new Employee("Arnold", "Shwarzenegger", 145451, 1),
//            new Employee("Silvester", "Stalone", 187344, 2),
//            new Employee("Bruce", "Lee", 156797, 1),
//            new Employee("Steven", "Sigal", 198372, 2),
//            new Employee("Chuck", "Norris", 139339, 1),
//            new Employee("Bruce", "Willis", 184839, 2)
//    ));

//    public Employee maxSalary(int department) { Для массива
//        return employees.stream()
//                .filter(e -> e.getDepartment() == (department))
//                .max(Comparator.comparing(employee -> employee.getSalary()))
//                .orElseThrow(null);
//    }
}


//    public Employee maxSalary(int department) {
//        Optional<Employee> maxSalary = employees.stream()
//                .filter(e -> e.getDepartment() == (department))
//                .max(Comparator.comparing(employee -> employee.getSalary()));
//        return maxSalary.orElseThrow(() -> new RuntimeException("Employee not found"));
//    }
