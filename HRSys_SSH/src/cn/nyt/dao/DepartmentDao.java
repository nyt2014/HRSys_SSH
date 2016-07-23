package cn.nyt.dao;

import java.util.List;

import cn.nyt.bean.Department;

public interface DepartmentDao {
	
	public Department findById(int id);
	
	public List<Department> getAllDept();
}
