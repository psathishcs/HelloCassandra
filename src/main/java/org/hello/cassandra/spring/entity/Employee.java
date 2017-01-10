package org.hello.cassandra.spring.entity;

import java.math.BigInteger;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;


@Table("emp")
public class Employee {
	
	@PrimaryKey
	int emp_id;
	String emp_name;
	String emp_city;
	BigInteger emp_sal;
	BigInteger emp_phone;
	
	/**
	 * @return the emp_id
	 */
	public int getEmp_id() {
		return emp_id;
	}
	/**
	 * @param emp_id the emp_id to set
	 */
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	/**
	 * @return the emp_name
	 */
	public String getEmp_name() {
		return emp_name;
	}
	/**
	 * @param emp_name the emp_name to set
	 */
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	/**
	 * @return the emp_city
	 */
	public String getEmp_city() {
		return emp_city;
	}
	/**
	 * @param emp_city the emp_city to set
	 */
	public void setEmp_city(String emp_city) {
		this.emp_city = emp_city;
	}
	/**
	 * @return the emp_sal
	 */
	public BigInteger getEmp_sal() {
		return emp_sal;
	}
	/**
	 * @param emp_sal the emp_sal to set
	 */
	public void setEmp_sal(BigInteger emp_sal) {
		this.emp_sal = emp_sal;
	}
	/**
	 * @return the emp_phone
	 */
	public BigInteger getEmp_phone() {
		return emp_phone;
	}
	/**
	 * @param emp_phone the emp_phone to set
	 */
	public void setEmp_phone(BigInteger emp_phone) {
		this.emp_phone = emp_phone;
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append(emp_id).append(", ");
		builder.append(emp_name).append(", ");
		builder.append(emp_city).append(", ");
		builder.append(emp_phone).append(", ");
		builder.append(emp_sal).append(".");
		return builder.toString();
	}
}