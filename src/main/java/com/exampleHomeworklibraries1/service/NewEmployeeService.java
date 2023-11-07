package com.exampleHomeworklibraries1.service;

import java.util.List;
import java.util.Map;

public interface NewEmployeeService {

    Employee maxSalaryFromMap(int department);

    Employee minSalary(int department);

    List<Employee> allEmployees(int department);

    Map<Integer, List <Employee>> all();

//    Employee maxSalary(int department);
}
