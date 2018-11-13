package com.br.nice.daoHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.br.nice.conection.HibernateUtil;
import com.br.nice.model.User;

public class UserDaoHibernate{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session = HibernateUtil.getConexaoBaseLocal().openSession();
	private Transaction transaction = this.session.beginTransaction();

	public void save(User user) {
		try {
			this.session.save(user);
			this.transaction.commit();

		} catch (Exception e) {
			System.out.println("Não foi possível inserir. Erro:" + e.getMessage());
			e.printStackTrace();
		}
		try {
			if (this.session.isOpen()) {
				this.session.close();
			}
		} catch (Throwable e) {
			System.out.println("Erro ao fechar a operação. Mensagem:" + e.getMessage());
		}
	}

	public void update(User user) {
		try {
			this.session.update(user);
			this.transaction.commit();

		} catch (HibernateException e) {
			System.out.println("Não foi possível alterar. Erro:" + e.getMessage());
		} finally {
			try {
				if (this.session.isOpen()) {
					this.session.close();
				}
			} catch (Throwable e) {
				System.out.println("Erro ao fechar a operação. Mensagem:" + e.getMessage());
			}
		}
	}

	public void delete(User user) {
		try {
			this.session.delete(user);
			this.transaction.commit();

		} catch (HibernateException e) {
			System.out.println("Não foi possível deletar. Erro:" + e.getMessage());
		} finally {
			try {
				if (this.session.isOpen()) {
					this.session.close();
				}
			} catch (Throwable e) {
				System.out.println("Erro ao fechar a operação. Mensagem:" + e.getMessage());
			}
		}
	}

	public User chargeUser(Long id) {
		return (User) this.session.get(User.class, id);
	}

	public User searchByLogin(String login) {
		String hql = "SELECT u FROM User u WHERE u.login =:login";
		Query search = this.session.createQuery(hql);
		search.setString("login", login);
		return (User) search.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<User> list() {
		String hql = "FROM User u ORDER BY u.name ASC";
		Query query = session.createQuery(hql);
		this.transaction.commit();

		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<User> consultUser(String name) {
		Query query = session.createQuery("FROM User WHERE name like :name");
		query.setParameter("name", "%" + name + "%");
		return query.list();

	}

}
