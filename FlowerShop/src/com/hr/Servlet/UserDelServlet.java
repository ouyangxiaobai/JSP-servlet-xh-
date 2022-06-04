package com.hr.Servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_USERDao;
import com.hr.util.EncodeUtil;

public class UserDelServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	EncodeUtil.encode(req);
	resp.setContentType("text/html;charset=utf-8");
	String id=req.getParameter("id");
	PrintWriter out=resp.getWriter();
	int count=EASYBUY_USERDao.del(id);
	if(count>0){
		resp.sendRedirect("manage-result.jsp");
	}else{
		out.write("<script>");
		out.write("alert('删除失败');");
		out.write("location.href='user.jsp'");
		out.write("</script>");
		out.close();
	}
}
}
