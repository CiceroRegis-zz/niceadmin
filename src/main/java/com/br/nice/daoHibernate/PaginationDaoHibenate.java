package com.br.nice.daoHibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.br.nice.conection.HibernateUtil;
import com.br.nice.model.User;

public class PaginationDaoHibenate {

	private Session session = HibernateUtil.getConexaoBaseLocal().openSession();
	private Transaction transaction = this.session.beginTransaction();
	
	
	
	@SuppressWarnings("unchecked")
	public List<User> getListUser(int firstRow, int rowCount) {
        List<User> userList = null;
        try {
            Criteria criteria = session.createCriteria(User.class);
            criteria.setFirstResult(firstRow);
            criteria.setMaxResults(rowCount);
            if (criteria != null) {
            	userList  =  criteria.list();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList ;
    }

    public int countRows() {
        try {
            Criteria criteria = session.createCriteria(User.class);
            if (criteria != null) {
                return criteria.list().size();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    
}
