package cn.nyt.service;

import cn.nyt.bean.Administrator;

public interface AdministratorService {

	/**
	 * ��½
	 */
	public Administrator login(Administrator admin);

	/**
	 * ע��
	 */
	public void register(Administrator admin);

}
