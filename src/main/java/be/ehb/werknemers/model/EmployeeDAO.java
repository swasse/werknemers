package be.ehb.werknemers.model;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeDAO extends CrudRepository<Employee, Integer> {

    Iterable<Employee> findAllByName (String name);

}
