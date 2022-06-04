package com.web.shopservlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.ESDao;
import com.hr.entity.eb_shop;

public class UpdateServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		arg1.setContentType("text/html;charset=utf-8");
		PrintWriter out = arg1.getWriter();
		String str1=arg0.getParameter("pid");
		String str2=arg0.getParameter("action");
		String str3=arg0.getParameter("getvalue");
		if(str2.equals("jia")){
			int count=ESDao.updateJia(Integer.parseInt(str1));
		}
		if(str2.equals("jian")){
			int count=ESDao.updateJian(Integer.parseInt(str1));
			
		}
		if(str2.equals("closeText")){
			eb_shop es=new eb_shop(Integer.parseInt(str1), "1", "1", 1, Integer.parseInt(str3), 1, 1, "1", 1);
			int count=ESDao.updateClose(es);
		}
		if(str2.equals("delText")){
			int count=ESDao.getDeleteDD(Integer.parseInt(str1));
		}
		arg1.sendRedirect("ShopSelect");
	}
}
