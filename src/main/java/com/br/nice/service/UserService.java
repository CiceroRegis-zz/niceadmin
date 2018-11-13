package com.br.nice.service;

import java.util.List;

import com.br.nice.daoHibernate.UserDaoHibernate;
import com.br.nice.model.User;

/**
 * 
 * @author cicinho
 *
 */

public class UserService {
	private UserDaoHibernate daoHibernate = new UserDaoHibernate();

	public User charge(Long id) {
		return this.daoHibernate.chargeUser(id);
	}

	public User searchByLogin(String login) {
		return this.daoHibernate.searchByLogin(login);
	}

	public void save(User user) {

		Long id = user.getId();
		if (id == null) {
			this.daoHibernate.save(user);
		} else {
			this.daoHibernate.update(user);
		}
	}

	public void delete(User user) {
		this.daoHibernate.delete(user);
	}

	public List<User> list() {
		return daoHibernate.list();
	}

	public List<User> consultUser(String name) {
		return daoHibernate.consultUser(name);
	}

	public User findByUserName(String login) {
		return daoHibernate.searchByLogin(login);
	}

}
