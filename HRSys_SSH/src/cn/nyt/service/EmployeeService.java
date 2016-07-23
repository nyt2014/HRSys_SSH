package cn.nyt.service;

import java.util.List;

import cn.nyt.bean.Employee;

public interface EmployeeService {

	// ����
	public void saveEmp(Employee employee);

	// ��������ɾ��
	public void deleteEmp(int id);

	// ����
	public void updateEmp(Employee employee);

	// ����id��ѯһ��Ա��
	public Employee findById(int id);

	// ��ѯ����Ա��
	public List<Employee> getAll();

	// �������ƽ���ģ����ѯ
	public List<Employee> getAll(String empName);

	// ���ݶ��idɾ�����Ա��
	public void deleteEmps(int[] ids);
}
