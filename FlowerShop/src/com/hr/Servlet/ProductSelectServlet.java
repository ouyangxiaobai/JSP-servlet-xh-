package com.hr.Servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_PRODUCTDao;
import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_PRODUCT;

public class ProductSelectServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		int cpage = 1;//当前页数
		int count = 5;//每页行数
		String cp = req.getParameter("cp");
		if(cp!=null){//如果页面上传递了页数,将当前页数改变掉
			cpage = Integer.parseInt(cp);
		}
		//查出总页数
		int tpage = 0;
		ArrayList<EASYBUY_PRODUCT> eplist = EASYBUY_PRODUCTDao.selectAll(cpage, count);
		tpage = EASYBUY_PRODUCTDao.totalPage(count);
		
		req.setAttribute("eplist", eplist);
		//当前页数
		req.setAttribute("cpage", cpage);
		//总页数
		req.setAttribute("tpage", tpage);
		req.getRequestDispatcher("product.jsp").forward(req, resp);
	}
}
