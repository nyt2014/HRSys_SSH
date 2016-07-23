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

	// 注入员工服务EmployeeService
	private EmployeeService emplService;

	public void setEmplService(EmployeeService emplService) {
		this.emplService = emplService;
	}

	// 注入部门服务DepartmentService
	public DepartmentService deptService;

	public void setDeptService(DepartmentService deptService) {
		this.deptService = deptService;
	}

	/**
	 * 实现了RequestAware接口 接收框架运行时传入的代表request对象的map集合
	 */
	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	/**
	 * 1.获取员工列表
	 */
	public String listEmpls() {

		// 获取所有员工
		List<Employee> empls = emplService.getAll();
		// 获取所有部门(这里不需要再获取部门存入request，在视图中可以从employee中获取到对应部门的属性)
//		List<Department> depts = deptService.getAllDept();

		// 保存到request
		// Map<String, Object> request=(Map<String, Object>)
		// ActionContext.getContext().get("request");
		this.request.put("empls", empls);
//		this.request.put("depts", depts);

		return "listEmpls";
	}

	/**
	 * 2.员工添加视图
	 */
	public String addEmplView() {
		// 先获取所有部门
		List<Department> depts = deptService.getAllDept();
		// 保存到request
		this.request.put("depts", depts);
		return "addEmplView";
	}

	/****************************************************
	 * 实现ModelDriver接口，使用模型驱动封装请求带过来的员工数据
	 *****************************************************/
	private Employee employee = new Employee();

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	// 封装请求带过来的部门id:deptId
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
	 * 3.保存员工
	 */
	public String saveEmpl() {
		// 根据请求传过来的deptId查询部门
		Department dept = deptService.findById(deptId);

		// 设置到由模型驱动封装好其他请求数据的employee中
		employee.setDept(dept);

		// 保存员工
		emplService.saveEmp(employee);

		// 添加成功，进入列表
		// (防止刷新就多一条记录问题，所以在视图跳转到员工列表页面时一定要使用重定向)
		return SUCCESS;
	}

	/**
	 * 4.Forward Update Employee View
	 */
	public String updateEmplView() {
		/**
		 * 取出修改需要回显的所有数据
		 */
		// 获取请求只带过来的员工id，并由struts的模型驱动封装到的employee中
		int id = employee.getId();

		// 根据id获取数据库具体员工对象
		Employee empl = emplService.findById(id);

		// 获取所有部门
		List<Department> depts = deptService.getAllDept();

		// 获取值栈
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.pop();// 移除栈顶元素
		vs.push(empl);// 将封装了需要回显数据的员工对象压入栈顶

		// 将部门集合保存到代表request的map集合
		request.put("depts", depts);

		return "updateEmplView";
	}

	/**
	 * 5. Update Employee
	 */
	public String updateEmpl() {

		// 根据请求传过来由模型驱动已经封装好的部门deptId查询部门
		Department dept = deptService.findById(deptId);

		// 设置给员工
		employee.setDept(dept);

		// 更新员工信息
		emplService.updateEmp(employee);

		// 重定向到员工列表
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
