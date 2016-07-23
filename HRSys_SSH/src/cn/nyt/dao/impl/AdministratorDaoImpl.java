package cn.nyt.dao.impl;

import org.hibernate.SessionFactory;

import cn.nyt.bean.Administrator;
import cn.nyt.dao.AdministratorDao;

public class AdministratorDaoImpl extends BaseDaoImpl<Administrator> implements AdministratorDao {

	/*// IOC����ע��localSessionFactoryBean
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/

	@Override
	public Administrator findByAdmin(Administrator admin) {

		return (Administrator) super.getSessionFactory().getCurrentSession()//
				.createQuery("FROM Administrator WHERE adminName=? and pwd=?")//
				.setParameter(0, admin.getAdminName())//
				.setParameter(1, admin.getPwd())//
				.uniqueResult();
	}

	/*@Override
	public void save(Administrator admin) {
		sessionFactory.getCurrentSession().save(admin);
	}*/

}
