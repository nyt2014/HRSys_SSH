package cn.nyt.service.impl;

import cn.nyt.bean.Administrator;
import cn.nyt.dao.AdministratorDao;
import cn.nyt.service.AdministratorService;

public class AdministratorServiceImpl implements AdministratorService {

	private AdministratorDao adao;

	public void setAdao(AdministratorDao adao) {
		this.adao = adao;
	}

	@Override
	public Administrator login(Administrator admin) {
		return adao.findByAdmin(admin);
	}

	@Override
	public void register(Administrator admin) {
		adao.save(admin);
	}

}
