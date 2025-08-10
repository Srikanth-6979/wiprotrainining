package com.wipro.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/httpserv")
public class HttpServletDemo extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("--- HttpServlet ---");  
        
        PrintWriter out= resp.getWriter();
		out.print("<h1>Hello HttpServlet.....!!!!!</h1>");
    }
}
