package com.wipro.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/hello")
public class ServletDemo implements Servlet {

	@Override
	public void destroy() {
		

	}

	@Override
	public ServletConfig getServletConfig() {
		
		return null;
	}

	@Override
	public String getServletInfo() {
		
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("---- init ----");

	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		
		System.out.println("---- service ----");
//		 resp.setContentType("text/html");
//		 resp.getWriter().println("<h1>Hello Servlet!!!!</h1>");
		
		PrintWriter out= resp.getWriter();
		out.print("<h1>Hello Servlet</h1>");

	}


}
