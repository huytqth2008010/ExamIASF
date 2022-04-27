package aptech.t2008m.examiasf.employees.service;

import aptech.t2008m.examiasf.employees.entity.Employee;
import aptech.t2008m.examiasf.employees.model.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> findAll(String name){
        return employeeRepository.findAllEmployees(name);
    }
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }
    public void deleteById(Integer id){
        employeeRepository.deleteById(id);
    }
}
