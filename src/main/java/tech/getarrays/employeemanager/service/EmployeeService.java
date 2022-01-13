package tech.getarrays.employeemanager.service;

import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repository.EmployeeRepository;
import tech.getarrays.employeemanager.service.exception.ServiceExceptionMessage;
import tech.getarrays.employeemanager.service.exception.impl.UserNotFoundException;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format(ServiceExceptionMessage.USER_NOTFOUND_SERVICE_MESSAGE, id)));
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
