package aptech.t2008m.examiasf.employees.api;



import aptech.t2008m.examiasf.employees.entity.Employee;
import aptech.t2008m.examiasf.employees.model.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/employees")
public class EmployeeApi {

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getList(@RequestParam(defaultValue = "") String name){
        if(name.length() > 0){
            return employeeRepository.findAllEmployees(name);
        }else {
            return employeeRepository.findAll();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Employee save(@RequestBody Employee employee){
        employeeRepository.save(employee);
        return employee;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Employee getDetail(@PathVariable int id){
        return employeeRepository.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public boolean delete(@PathVariable int id){
        employeeRepository.deleteById(id);
        return true;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public Employee update(@PathVariable int id, @RequestBody Employee updateEmployee){
        Employee existing = employeeRepository.findById(id).get();
        existing.setName(updateEmployee.getName());
        existing.setWage(updateEmployee.getWage());
        employeeRepository.save(existing);
        return updateEmployee;
    }
}
