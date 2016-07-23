package cn.nyt.dao;

import java.util.List;

public interface BaseDao<T> {

	/**
	 * dao类通用操作接口
	 * 使用到反射泛型技术
	 */
	/**
	 * add
	 * @param t
	 */
	void save(T t);
	/**
	 * delece
	 * @param id
	 */
	void delete(int id); 
	/**
	 * update
	 * @param t
	 */
	void update(T t);
	/**
	 * query
	 * @param id
	 * @return
	 */
	T findById(int id);
	/**
	 * query
	 * @return
	 */
	List<T> getAll();
	
}
