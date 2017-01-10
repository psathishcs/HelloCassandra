package org.hello.cassandra.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.hello.cassandra.spring.entity.Employee;
import org.hello.cassandra.spring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@RequestMapping(value="/employees", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> employees() {
		List<Employee> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(e -> employees.add(e));
		return employees;
	}

	@RequestMapping(value="/employees/{empID}", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> getEmployees(@PathVariable String empID) {
		List<Employee> employees = new ArrayList<>();
		employeeRepository.findByID(Integer.parseInt(empID)).forEach(e -> employees.add(e));
		return employees;
	}
	
	@RequestMapping(value="/employee", method = RequestMethod.POST)
	@ResponseBody
	public String addEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return "OK";
	}
	
	@RequestMapping(value="/employees", method = RequestMethod.POST)
	@ResponseBody
	public String AddListOfEmployees(@RequestBody List<Employee> employees) {
		for (Employee employee : employees)
			employeeRepository.save(employee);
		return "OK";
	}
	
	@RequestMapping(value="/employees", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteEmployee(@RequestBody Employee employee) {
			employeeRepository.delete(employee);
		return "OK";
	}
}
