package com.hr.Servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_PRODUCTDao;

public class ProductDelServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		int count = EASYBUY_PRODUCTDao.del(Integer.parseInt(id));
		if(count>0){
			req.getRequestDispatcher("productSelect").forward(req, resp);
		}
	}
}
