package by.parfenkov.service;

import by.parfenkov.beans.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private static volatile EmployeeService instance;

    public static EmployeeService getService() {
        if (null == instance) {
            synchronized (EmployeeService.class) {
                if (null == instance) {
                    instance = new EmployeeService();
                }
            }
        }
        return instance;
    }

    public Optional<Employee> add(Employee employee) {
        return Optional.empty();
    }

    public Optional<Employee> set(Employee employee) {
        return Optional.empty();
    }

    public Optional<Employee> remove(Employee employee) {
        return Optional.empty();
    }

    public Optional<Employee> get(long id) {
        return Optional.empty();
    }

    public List<Employee> getAll() {
        return null;
    }

    private EmployeeService() {

    }
}
