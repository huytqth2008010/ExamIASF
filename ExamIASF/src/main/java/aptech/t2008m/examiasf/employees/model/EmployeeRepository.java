package aptech.t2008m.examiasf.employees.model;



import aptech.t2008m.examiasf.employees.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "SELECT * FROM employees a WHERE a.name LIKE %:name%",
            nativeQuery = true)
    List<Employee> findAllEmployees(
            @Param("name") String name);

}
