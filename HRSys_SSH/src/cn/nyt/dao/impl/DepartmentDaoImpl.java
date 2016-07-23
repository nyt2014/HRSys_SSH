package cn.nyt.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import cn.nyt.bean.Department;
import cn.nyt.dao.DepartmentDao;

public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao {
	/*// IOCÈÝÆ÷×¢ÈëlocalSessionFactoryBean
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Department findById(int id) {
		
		 * return (Department) sessionFactory.getCurrentSession()//
		 * .createQuery("FROM Department WHERE id=?")// .setParameter(0, id)//
		 * .uniqueResult();
		 
		return (Department) sessionFactory.getCurrentSession().get(
				Department.class, id);

	}

	@Override
	public List<Department> getAllDept() {
		return sessionFactory.getCurrentSession()//
				.createQuery("FROM Department")//
				.list();

	}*/

}
