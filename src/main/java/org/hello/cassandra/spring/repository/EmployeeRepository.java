package org.hello.cassandra.spring.repository;

import org.hello.cassandra.spring.entity.Employee;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CassandraRepository<Employee>{
	@Query("SELECT * FROM emp WHERE emp_id=?0")
	Iterable<Employee> findByID(int empID);
	
}
