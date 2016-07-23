package cn.nyt.dao;

import java.util.List;

import cn.nyt.bean.Employee;

public interface EmployeeDao {
	

	public void saveEmp(Employee employee);
	
	public void deleteEmp(int id);
	
	public void updateEmp(Employee employee);
	
	public Employee findById(int id);
	
	public List<Employee> getAll();
	
	public List<Employee> getAll(String empName);
	
}
