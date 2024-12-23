package com.raysi.springboot3.service;

import com.raysi.springboot3.entity.Employee;
import com.raysi.springboot3.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class EmployeeServiceImplementation implements EmployeeService{

    private  final EmployeeRepository employeeRepository;

    public EmployeeServiceImplementation(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void saveEmployees(List<Employee> employees) {
        employeeRepository.saveAll(employees);
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {

        log.info("Trying to update employee for employee id {}", id);
        Employee emp = employeeRepository.findById(id).get();

        if(Objects.nonNull(employee.getName())
        &&!"".equalsIgnoreCase(employee.getName())
        ){
            emp.setName(employee.getName());
        }

        if(Objects.nonNull(employee.getEmail()) &&
        !"".equalsIgnoreCase(employee.getEmail())
        ){
            emp.setEmail(employee.getEmail());
        }

        if(Objects.nonNull((employee.getAge()))
        &&!"".equalsIgnoreCase(String.valueOf(employee.getAge()))
        ){
            emp.setAge(employee.getAge());
        }

        if(Objects.nonNull((employee.getPhoneNo()))
                &&!"".equalsIgnoreCase(employee.getPhoneNo())
        ){
            emp.setPhoneNo(employee.getPhoneNo());
        }
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
