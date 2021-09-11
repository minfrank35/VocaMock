package com.tvtcenter;

import javax.servlet.ServletContext;

import javax.servlet.ServletContextEvent;


public class ServletContextListener implements javax.servlet.ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		javax.servlet.ServletContextListener.super.contextInitialized(sce);
			ServletContext context = sce.getServletContext();

		
		String dbcpResourceName = context.getInitParameter("dbcp_resource_name");
		
		LoginDAO ldao = new LoginDAO(dbcpResourceName);
		context.setAttribute("ldao", ldao);
		
	}
	
}
