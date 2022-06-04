package com.hr.Servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import com.hr.util.EncodeUtil;

public class DoProductClassAddServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		EncodeUtil.encode(req);
		int fid = Integer.parseInt(req.getParameter("parentId"));
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("className");
		if(fid==0){
			EASYBUY_PRODUCT_CATEGORY pc = new EASYBUY_PRODUCT_CATEGORY(0, name, 0);
			EASYBUY_PRODUCT_CATEGORYDao.insertOnFather(pc);
		}else{
			EASYBUY_PRODUCT_CATEGORY pc = new EASYBUY_PRODUCT_CATEGORY(0, name, fid);
			EASYBUY_PRODUCT_CATEGORYDao.insert(pc);
		}
		resp.sendRedirect("productClass");
	}
}
