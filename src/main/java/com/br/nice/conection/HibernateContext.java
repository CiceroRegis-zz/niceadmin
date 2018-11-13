package com.br.nice.conection;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 
 * @author cicinho
 *
 */

public class HibernateContext implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		HibernateUtil.getConexaoBaseLocal();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtil.getConexaoBaseLocal().close();

	}

}
