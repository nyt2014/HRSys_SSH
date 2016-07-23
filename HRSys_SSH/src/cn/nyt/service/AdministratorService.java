package cn.nyt.service;

import cn.nyt.bean.Administrator;

public interface AdministratorService {

	/**
	 * µÇÂ½
	 */
	public Administrator login(Administrator admin);

	/**
	 * ×¢²á
	 */
	public void register(Administrator admin);

}
