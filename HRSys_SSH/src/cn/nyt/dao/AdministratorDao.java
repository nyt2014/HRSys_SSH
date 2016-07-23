package cn.nyt.dao;

import cn.nyt.bean.Administrator;

public interface AdministratorDao extends BaseDao<Administrator>{

	public Administrator findByAdmin(Administrator admin);

	/*public void save(Administrator admin);*/

}
