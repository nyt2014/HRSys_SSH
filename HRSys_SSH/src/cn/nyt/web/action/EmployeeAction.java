package cn.nyt.web.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import cn.nyt.bean.Department;
import cn.nyt.bean.Employee;
import cn.nyt.service.DepartmentService;
import cn.nyt.service.EmployeeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class EmployeeAction extends ActionSupport implements
		ModelDriven<Employee>, RequestAware {

	// ע��Ա������EmployeeService
	private EmployeeService emplService;

	public void setEmplService(EmployeeService emplService) {
		this.emplService = emplService;
	}

	// ע�벿�ŷ���DepartmentService
	public DepartmentService deptService;

	public void setDeptService(DepartmentService deptService) {
		this.deptService = deptService;
	}

	/**
	 * ʵ����RequestAware�ӿ� ���տ������ʱ����Ĵ���request�����map����
	 */
	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	/**
	 * 1.��ȡԱ���б�
	 */
	public String listEmpls() {

		// ��ȡ����Ա��
		List<Employee> empls = emplService.getAll();
		// ��ȡ���в���(���ﲻ��Ҫ�ٻ�ȡ���Ŵ���request������ͼ�п��Դ�employee�л�ȡ����Ӧ���ŵ�����)
//		List<Department> depts = deptService.getAllDept();

		// ���浽request
		// Map<String, Object> request=(Map<String, Object>)
		// ActionContext.getContext().get("request");
		this.request.put("empls", empls);
//		this.request.put("depts", depts);

		return "listEmpls";
	}

	/**
	 * 2.Ա�������ͼ
	 */
	public String addEmplView() {
		// �Ȼ�ȡ���в���
		List<Department> depts = deptService.getAllDept();
		// ���浽request
		this.request.put("depts", depts);
		return "addEmplView";
	}

	/****************************************************
	 * ʵ��ModelDriver�ӿڣ�ʹ��ģ��������װ�����������Ա������
	 *****************************************************/
	private Employee employee = new Employee();

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	// ��װ����������Ĳ���id:deptId
	private int deptId;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	@Override
	public Employee getModel() {
		return employee;
	}

	/**
	 * 3.����Ա��
	 */
	public String saveEmpl() {
		// �������󴫹�����deptId��ѯ����
		Department dept = deptService.findById(deptId);

		// ���õ���ģ��������װ�������������ݵ�employee��
		employee.setDept(dept);

		// ����Ա��
		emplService.saveEmp(employee);

		// ��ӳɹ��������б�
		// (��ֹˢ�¾Ͷ�һ����¼���⣬��������ͼ��ת��Ա���б�ҳ��ʱһ��Ҫʹ���ض���)
		return SUCCESS;
	}

	/**
	 * 4.Forward Update Employee View
	 */
	public String updateEmplView() {
		/**
		 * ȡ���޸���Ҫ���Ե���������
		 */
		// ��ȡ����ֻ��������Ա��id������struts��ģ��������װ����employee��
		int id = employee.getId();

		// ����id��ȡ���ݿ����Ա������
		Employee empl = emplService.findById(id);

		// ��ȡ���в���
		List<Department> depts = deptService.getAllDept();

		// ��ȡֵջ
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.pop();// �Ƴ�ջ��Ԫ��
		vs.push(empl);// ����װ����Ҫ�������ݵ�Ա������ѹ��ջ��

		// �����ż��ϱ��浽����request��map����
		request.put("depts", depts);

		return "updateEmplView";
	}

	/**
	 * 5. Update Employee
	 */
	public String updateEmpl() {

		// �������󴫹�����ģ�������Ѿ���װ�õĲ���deptId��ѯ����
		Department dept = deptService.findById(deptId);

		// ���ø�Ա��
		employee.setDept(dept);

		// ����Ա����Ϣ
		emplService.updateEmp(employee);

		// �ض���Ա���б�
		return SUCCESS;
	}

	/**
	 * 6.Delete Employee
	 */
	public String deleteEmpl() {

		int id = employee.getId();
		emplService.deleteEmp(id);

		return SUCCESS;
	}
	
	/**
	 * 7.Add Department
	 */
	public String addDeptView(){
		
		return "addDeptView";
	}
	
	/**
	 * 8.Search Employee Name
	 */
	public String searchEmpls(){
		List<Employee> empls = emplService.getAll(employee.getEmpName());
		request.put("empls", empls);
		return "listEmpls";
	}
	

}
