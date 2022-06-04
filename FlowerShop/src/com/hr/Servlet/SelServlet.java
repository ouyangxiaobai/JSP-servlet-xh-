package com.hr.Servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_COMMENTDao;
import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_COMMENT;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;

public class SelServlet extends HttpServlet {
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			//前台查询所有
			ArrayList<EASYBUY_COMMENT> list = EASYBUY_COMMENTDao.selectAll();
			ArrayList<EASYBUY_PRODUCT_CATEGORY> flist = EASYBUY_PRODUCT_CATEGORYDao.selectFather();
			req.setAttribute("flist", flist);
			ArrayList<EASYBUY_PRODUCT_CATEGORY> clist = EASYBUY_PRODUCT_CATEGORYDao.selectChild();
			req.setAttribute("clist", clist);
	 		//寄包裹
	 	 	req.setAttribute("list", list);
	 		//转发
	 	 	req.getRequestDispatcher("guestbook.jsp").forward(req,resp);
		}
}
