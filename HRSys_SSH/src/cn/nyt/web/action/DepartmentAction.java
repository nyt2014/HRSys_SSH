package cn.nyt.web.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import cn.nyt.bean.Department;
import cn.nyt.service.DepartmentService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department>, RequestAware {

	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}

	private Department department=new Department();
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public Department getModel() {
		return department;
	}
	
	private DepartmentService deptService;
	public void setDeptService(DepartmentService deptService) {
		this.deptService = deptService;
	}
	
	/**
	 * 1.Forward Department View
	 */
	public String addDeptView(){
		
		return "addDeptView";
	}

	/**
	 * 2.Add Department
	 */
	public String addDept(){
		
		deptService.save(department);
		
		return SUCCESS;
	}
}
