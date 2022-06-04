package com.hr.Servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckUserNumServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	String num =req.getParameter("num");
	HttpSession session = req.getSession();
	String sysCode = (String)session.getAttribute("syscode");
	PrintWriter out  = resp.getWriter();
	if(sysCode.equals(num)){
		out.print("true");
	}else {
		out.print("false");
	}
	out.close();
	}

}
