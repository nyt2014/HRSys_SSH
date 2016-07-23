package cn.nyt.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 管理员权限Struts2拦截器：ActionInvocation 检查管理员是否登陆，只有登陆之后才能对员工信息进行操作 没有登陆则只能查看列表
 */

public class AdminPrivilegeInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 得到当前执行的方法名
		String methodName = invocation.getProxy().getMethod();
		// 获取当前所在的Action的名称
		String actionName = invocation.getProxy().getActionName();
		// 得到ActionContext对象
		ActionContext ac = invocation.getInvocationContext();
		// 获取session，从session中获取登陆的管理员对象
		Object obj = ac.getSession().get("admin");

		// 判断执行的方法
		if (!"login".equals(methodName)//
				&& !"listEmpls".equals(methodName)//
				&& !"register".equals(actionName)//
				&& !"adminRegister".equals(methodName)
				&& !"searchEmpls".equals(methodName)) { //
			// 如果当前执行的方法不是login()和listEmpls()
			// 则判断管理员对象是否为空
			if (obj == null) {
				// 没有登陆，则执行login()方法
				return "loginView";// 这个返回值的作用和Action返回值的作用相同
			} else {
				// 已登录，让当前方法执行
				return invocation.invoke();
			}

		} else {
			// 如果当前执行的方法是登陆和或许员工列表方法
			// 允许执行当前方法
			return invocation.invoke();
		}
	}

}
