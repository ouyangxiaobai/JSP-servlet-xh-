package com.hr.Servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_USERDao;
import com.hr.entity.EASYBUY_USER;

public class UserServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		int cpage=1;
		int count=15;
		String cp=req.getParameter("cp");
		if(cp!=null){
			cpage=Integer.parseInt(cp);
		}
		int tpage=EASYBUY_USERDao.totalPage(count);
		ArrayList<EASYBUY_USER> list=EASYBUY_USERDao.selectAll(cpage,count);
		req.setAttribute("userlist", list);
		req.setAttribute("cpage", cpage);
		req.setAttribute("tpage", tpage);
		req.getRequestDispatcher("user.jsp").forward(req, resp);
}
}
