package cn.nyt.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * ����ԱȨ��Struts2��������ActionInvocation ������Ա�Ƿ��½��ֻ�е�½֮����ܶ�Ա����Ϣ���в��� û�е�½��ֻ�ܲ鿴�б�
 */

public class AdminPrivilegeInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// �õ���ǰִ�еķ�����
		String methodName = invocation.getProxy().getMethod();
		// ��ȡ��ǰ���ڵ�Action������
		String actionName = invocation.getProxy().getActionName();
		// �õ�ActionContext����
		ActionContext ac = invocation.getInvocationContext();
		// ��ȡsession����session�л�ȡ��½�Ĺ���Ա����
		Object obj = ac.getSession().get("admin");

		// �ж�ִ�еķ���
		if (!"login".equals(methodName)//
				&& !"listEmpls".equals(methodName)//
				&& !"register".equals(actionName)//
				&& !"adminRegister".equals(methodName)
				&& !"searchEmpls".equals(methodName)) { //
			// �����ǰִ�еķ�������login()��listEmpls()
			// ���жϹ���Ա�����Ƿ�Ϊ��
			if (obj == null) {
				// û�е�½����ִ��login()����
				return "loginView";// �������ֵ�����ú�Action����ֵ��������ͬ
			} else {
				// �ѵ�¼���õ�ǰ����ִ��
				return invocation.invoke();
			}

		} else {
			// �����ǰִ�еķ����ǵ�½�ͻ���Ա���б���
			// ����ִ�е�ǰ����
			return invocation.invoke();
		}
	}

}
