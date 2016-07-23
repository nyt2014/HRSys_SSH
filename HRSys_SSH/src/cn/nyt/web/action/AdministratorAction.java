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
	 * serviceע�����
	 */
	private AdministratorService adminService;

	public void setAdminService(AdministratorService adminService) {
		this.adminService = adminService;
	}

	/**
	 * 1.Administrator Login
	 */
	public String login() {
		// ��¼��֤
		Administrator admin = adminService.login(administrator);
		if (admin == null) {
			//��������½��ͼ
			return "loginView";
		} else {
			//����session
			ActionContext.getContext().getSession().put("admin", admin);
			// ��¼�ɹ�
			return SUCCESS;
		}
	}
	
	/**
	 * 2.lou out
	 */
	public String logout(){
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		// �Ӵ�ӳ�����Ƴ�����ӳ���ϵ����ѡ��������
		session.clear();
		return SUCCESS;
	}
	
	/**
	 * 3. Register Administrator
	 */
	
	public String adminRegister(){
		//�����ݿ���ע��
		adminService.register(administrator);
		ActionContext.getContext().getSession().put("admin", administrator);
		
		return SUCCESS;
	}

}
