package cn.nyt.service.impl;

import java.util.List;

import cn.nyt.bean.Employee;
import cn.nyt.dao.EmployeeDao;
import cn.nyt.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao edao;

	public void setEdao(EmployeeDao edao) {
		this.edao = edao;
	}

	@Override
	public void saveEmp(Employee employee) {

		edao.saveEmp(employee);
	}

	@Override
	public void deleteEmp(int id) {
		edao.deleteEmp(id);
	}

	@Override
	public void updateEmp(Employee employee) {
		edao.updateEmp(employee);
	}

	@Override
	public Employee findById(int id) {
		return edao.findById(id);
	}

	@Override
	public List<Employee> getAll() {
		return edao.getAll();
	}

	@Override
	public List<Employee> getAll(String empName) {
		return edao.getAll(empName);
	}

	@Override
	public void deleteEmps(int[] ids) {
		if (ids != null && ids.length > 0) {
			for (int id : ids) {
				this.deleteEmp(id);
			}
		}
	}

}
