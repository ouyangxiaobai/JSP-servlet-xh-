package com.hr.Servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_USERDao;
import com.hr.entity.EASYBUY_USER;
import com.hr.util.EncodeUtil;

public class UserUpdateServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		EncodeUtil.encode(req);
		resp.setContentType("text/html;charset=utf-8");
		String id=req.getParameter("id");
		EASYBUY_USER user=EASYBUY_USERDao.selectById(id);
		req.setAttribute("user", user);
		req.getRequestDispatcher("user-modify.jsp").forward(req, resp);
	}
}
