package com.hr.Servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import com.hr.util.EncodeUtil;

public class DoProductClassUpdateServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		EncodeUtil.encode(req);
		int id = Integer.parseInt(req.getParameter("id"));
		int fid = Integer.parseInt(req.getParameter("parentId"));
		String name = req.getParameter("className");
		EASYBUY_PRODUCT_CATEGORY pc;
		if(fid==0){
			pc = new EASYBUY_PRODUCT_CATEGORY(id, name, id);
		}else{
			pc = new EASYBUY_PRODUCT_CATEGORY(id, name, fid);
		}
		EASYBUY_PRODUCT_CATEGORYDao.update(pc);
		resp.sendRedirect("productClass");
	}
}
