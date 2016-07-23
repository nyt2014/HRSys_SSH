package cn.nyt.dao;

import java.util.List;

import cn.nyt.bean.Employee;

public interface EmployeeDao extends BaseDao<Employee>{

	/*public void save(Employee employee);

	public void delete(int id);

	public void update(Employee employee);

	public Employee findById(int id);

	public List<Employee> getAll();*/

	public List<Employee> getAll(String empName);

}
