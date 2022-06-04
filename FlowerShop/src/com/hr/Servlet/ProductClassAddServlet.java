package com.hr.Servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;

public class ProductClassAddServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ArrayList<EASYBUY_PRODUCT_CATEGORY> epclist = EASYBUY_PRODUCT_CATEGORYDao.selectAll();
		req.setAttribute("epclist", epclist);
		req.getRequestDispatcher("productClass-add.jsp").forward(req, resp);
	}
}
