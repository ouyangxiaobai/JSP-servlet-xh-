package com.hr.Servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_NEWSDao;
import com.hr.entity.EASYBUY_NEWS;

public class NewsselectServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		int cpage=1;
		int count=10;
		String cp=req.getParameter("cp");
		if(cp!=null){
			cpage=Integer.parseInt(cp);
		}
		int tpage=EASYBUY_NEWSDao.totalPage(count);
		ArrayList<EASYBUY_NEWS> newslist=EASYBUY_NEWSDao.selectAll(cpage,count);
		req.setAttribute("newslist", newslist);
		req.setAttribute("cpage", cpage);
		req.setAttribute("tpage", tpage);
		req.getRequestDispatcher("news.jsp").forward(req, resp);
	}
}
