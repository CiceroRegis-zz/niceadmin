package com.br.nice.conection;

import org.hibernate.Session;

public class ConectionHibernate {
	public static void main(String[] args) { 
		Session sessao = null;
		       try{
		       sessao = HibernateUtil.getConexaoBaseLocal().openSession();
		       System.out.println("Conectou!");
		      } finally { 
		         sessao.close(); 
		     }
	}
}
