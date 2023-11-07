package com.exampleHomeworklibraries1.service;

import com.exampleHomeworklibraries1.exception.EmployeeAlreadyAddedException;
import com.exampleHomeworklibraries1.exception.EmployeeNotFoundException;
import com.exampleHomeworklibraries1.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    int employeesSize = 6;
    private final Map<String, Employee> employees = new HashMap<>(Map.of(
            "0", new Employee("Arnold", "Shwarzenegger", 189001,1),
            "1", new Employee("Silvester", "Stallone", 189002, 2),
            "2", new Employee("Bruce", "Lee", 189003, 1),
            "3", new Employee("Steven", "Segal", 189004, 2),
            "4", new Employee("Chuck", "Norris", 189005, 1),
            "5", new Employee("Bruce", "Willis", 189006, 2)
    ));

//    @Override
//    public List<Employee> findAll(){
//        List<Employee> employeeList = new ArrayList<>(employees.values());
//        return employeeList;
//    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.size() >= employeesSize) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);{
        }
        return employee;
    }
    @Override
    public Employee removeEmployee(String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee.getFullName());
            return employee;
        }
        throw new EmployeeNotFoundException();
    }
    @Override
    public Employee findEmployee(String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public Map<String, Employee> getMap() {
        return employees;
    }
}
