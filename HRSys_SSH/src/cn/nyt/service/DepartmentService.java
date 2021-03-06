package cn.nyt.service;

import java.util.List;

import cn.nyt.bean.Department;

public interface DepartmentService {

	public Department findById(int id);

	public List<Department> getAllDept();

	void delete(int id);

	void update(Department dept);

	List<Department> getAll();
	
	void save(Department dept);
}
