package cn.nyt.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import cn.nyt.bean.Employee;
import cn.nyt.dao.EmployeeDao;

public class EmployeeDaoImpl extends BaseDaoImpl<Employee> implements EmployeeDao {
	/*// IOC����ע��localSessionFactoryBean
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/

	/*@Override
	public void saveEmp(Employee employee) {

		sessionFactory.getCurrentSession().save(employee);
	}

	@Override
	public void deleteEmp(int id) {
		sessionFactory.getCurrentSession()//
				.createQuery("DELETE FROM Employee WHERE id=?")// ������ѯ
				.setParameter(0, id)// ���ò���
				.executeUpdate();// ִ�и���

	}

	@Override
	public void updateEmp(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);

	}

	@Override
	public Employee findById(int id) {
		return (Employee) sessionFactory.getCurrentSession().get(
				Employee.class, id);
	}

	@Override
	public List<Employee> getAll() {
		return sessionFactory.getCurrentSession()//
				.createQuery("FROM Employee")//
				.list();
	}*/

	public List<Employee> getAll(String empName) {

		return super.getSessionFactory().getCurrentSession()//
				.createQuery("FROM Employee WHERE empName LIKE ?")// ģ����ѯ
				.setParameter(0, "%" + empName + "%")//
				.list();
	}

}
