package com.hr.Servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_NEWSDao;
import com.hr.entity.EASYBUY_NEWS;

public class NewsSelectServlet2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		EASYBUY_NEWS n = null;
		if(id!=null){
			n = EASYBUY_NEWSDao.selectById(Integer.parseInt(id));
		}
		req.setAttribute("n", n);
		ArrayList<EASYBUY_NEWS> nlist = EASYBUY_NEWSDao.selectAll();
		req.setAttribute("nlist", nlist);
		req.getRequestDispatcher("news-view.jsp").forward(req, resp);
	}
}
