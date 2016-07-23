package cn.nyt.dao;

import cn.nyt.bean.Administrator;

public interface AdministratorDao {

	public Administrator findByAdmin(Administrator admin);
	
	public void save(Administrator admin);
	
}
