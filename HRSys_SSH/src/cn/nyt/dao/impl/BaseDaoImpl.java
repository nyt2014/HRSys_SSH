package cn.nyt.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.SessionFactory;

import cn.nyt.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {

	// 当前操作的实际bean对象的类对象（例如：Employee）
	private Class<T> clazz;
	// 类名
	private String className;

	// 反射泛型
	public BaseDaoImpl() {
		// Type 是 Java 编程语言中所有类型的公共高级接口
		// 获取当前对象类的公共高级接口
		Type type = this.getClass().getGenericSuperclass();
		// 转换为参数化接口类型
		ParameterizedType pt = (ParameterizedType) type;// BaseDaoImpl<Employee>
		// 得到实际类型(返回表示此类型实际类型参数的 Type 对象的数组)
		Type[] types = pt.getActualTypeArguments(); // BaseDaoImpl<T>中的T的实际类型参数数组

		clazz = (Class<T>) types[0];// Employee.class

		className = clazz.getSimpleName();// Employee
	}

	// spring容器注入sessionFactory
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 由于设为了私有，为了让子类继承获取到该属性，提供get方法
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
				//注意HQL语句的语法，注意空格！！！！
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
