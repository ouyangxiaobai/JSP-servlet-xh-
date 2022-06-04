package com.hr.Servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_NEWSDao;
import com.hr.entity.EASYBUY_NEWS;

public class NewsUpdServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		String id=req.getParameter("id");
		EASYBUY_NEWS news=EASYBUY_NEWSDao.selectById(Integer.parseInt(id));
		req.setAttribute("news", news);
		req.getRequestDispatcher("news-modify.jsp").forward(req, resp);
}
}
