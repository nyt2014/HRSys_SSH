package cn.nyt.service.impl;

import java.util.List;

import cn.nyt.bean.Department;
import cn.nyt.dao.DepartmentDao;
import cn.nyt.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentDao ddao;
	public void setDdao(DepartmentDao ddao) {
		this.ddao = ddao;
	}

	@Override
	public Department findById(int id) {
		return ddao.findById(id);
	}

	@Override
	public List<Department> getAllDept() {
		return ddao.getAllDept();
	}

}
