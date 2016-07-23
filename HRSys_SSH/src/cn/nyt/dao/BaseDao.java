package cn.nyt.dao;

import java.util.List;

public interface BaseDao<T> {

	/**
	 * dao��ͨ�ò����ӿ�
	 * ʹ�õ����䷺�ͼ���
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
