package cn.nyt.web.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import cn.nyt.bean.Administrator;
import cn.nyt.service.AdministratorService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdministratorAction extends ActionSupport implements
		ModelDriven<Administrator> {

	private Administrator administrator = new Administrator();

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	@Override
	public Administrator getModel() {
		return administrator;
	}

	/**
	 * service注入入口
	 */
	private AdministratorService adminService;

	public void setAdminService(AdministratorService adminService) {
		this.adminService = adminService;
	}

	/**
	 * 1.Administrator Login
	 */
	public String login() {
		// 登录验证
		Administrator admin = adminService.login(administrator);
		if (admin == null) {
			//跳回至登陆视图
			return "loginView";
		} else {
			//存入session
			ActionContext.getContext().getSession().put("admin", admin);
			// 登录成功
			return SUCCESS;
		}
	}
	
	/**
	 * 2.lou out
	 */
	public String logout(){
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		// 从此映射中移除所有映射关系（可选操作）。
		session.clear();
		return SUCCESS;
	}
	
	/**
	 * 3. Register Administrator
	 */
	
	public String adminRegister(){
		//往数据库中注册
		adminService.register(administrator);
		ActionContext.getContext().getSession().put("admin", administrator);
		
		return SUCCESS;
	}

}
