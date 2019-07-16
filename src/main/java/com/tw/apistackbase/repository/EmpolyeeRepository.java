package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Employee;

import java.util.List;

public interface EmpolyeeRepository {
    List<Employee> findAll();

    Employee findById(String empolyeeId);

    Employee addEmpolyee(Employee employee);

    Employee removeEmpolyee(String empolyeeId);

    List<Employee> findAgeAbove(int ageMini);

    Employee updateEmpolyee(Employee employee);
}
