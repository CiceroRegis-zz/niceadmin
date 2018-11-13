package com.br.nice.test.User;

import java.util.Date;

import com.br.nice.daoHibernate.UserDaoHibernate;
import com.br.nice.model.User;

public class UserTest {

	public static void main(String[] args) {
		
		User user  = new User();
		UserDaoHibernate userDaoHibernate =  new UserDaoHibernate();
		
		user.setName("Cicero Regis");
		user.setBirthday(new Date());
		user.setEmail("ciceroregis25@gmail.com");
		user.setEnabled(true);
		user.setLanguage("pt_BR");
		user.setMobile("123456789");
		user.setPassword("cicinho1999");
		user.setLogin("cicinho1995");
		Long id = user.getId();
		if(id == null || id == 0) {
			userDaoHibernate.save(user);
			System.out.println("user cadastrado com sucesso");
		}else {
			System.out.println("erro ao tentar cadastra user");
		}
	}

}
