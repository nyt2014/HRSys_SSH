package cn.nyt.service;

import java.util.List;

import cn.nyt.bean.Employee;

public interface EmployeeService {

	// 保存
	public void saveEmp(Employee employee);

	// 根据主键删除
	public void deleteEmp(int id);

	// 更新
	public void updateEmp(Employee employee);

	// 根据id查询一个员工
	public Employee findById(int id);

	// 查询所有员工
	public List<Employee> getAll();

	// 根据名称进行模糊查询
	public List<Employee> getAll(String empName);

	// 根据多个id删除多个员工
	public void deleteEmps(int[] ids);
}
