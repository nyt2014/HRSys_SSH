package cn.nyt.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.SessionFactory;

import cn.nyt.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {

	// ��ǰ������ʵ��bean�������������磺Employee��
	private Class<T> clazz;
	// ����
	private String className;

	// ���䷺��
	public BaseDaoImpl() {
		// Type �� Java ����������������͵Ĺ����߼��ӿ�
		// ��ȡ��ǰ������Ĺ����߼��ӿ�
		Type type = this.getClass().getGenericSuperclass();
		// ת��Ϊ�������ӿ�����
		ParameterizedType pt = (ParameterizedType) type;// BaseDaoImpl<Employee>
		// �õ�ʵ������(���ر�ʾ������ʵ�����Ͳ����� Type ���������)
		Type[] types = pt.getActualTypeArguments(); // BaseDaoImpl<T>�е�T��ʵ�����Ͳ�������

		clazz = (Class<T>) types[0];// Employee.class

		className = clazz.getSimpleName();// Employee
	}

	// spring����ע��sessionFactory
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// ������Ϊ��˽�У�Ϊ��������̳л�ȡ�������ԣ��ṩget����
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public void save(T t) {
		sessionFactory.getCurrentSession().save(t);
	}

	@Override
	public void delete(int id) {
		sessionFactory.getCurrentSession()//
				//ע��HQL�����﷨��ע��ո񣡣�����
				.createQuery("DELETE FROM " + className + " WHERE id=?")//
				.setParameter(0, id)//
				.executeUpdate();
	}

	@Override
	public void update(T t) {
		sessionFactory.getCurrentSession().update(t);

	}

	@Override
	public T findById(int id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@Override
	public List<T> getAll() {
		return sessionFactory.getCurrentSession()//
				.createQuery("FROM "+className)//
				.list();
				
	}

}
