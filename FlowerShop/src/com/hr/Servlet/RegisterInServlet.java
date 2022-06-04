package com.hr.Servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hr.dao.EASYBUY_USERDao;
import com.hr.entity.EASYBUY_USER;

public class RegisterInServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");
	String username=req.getParameter("userName");
	String name=req.getParameter("name");
	String rePassWord=req.getParameter("rePassWord");
	String sex=req.getParameter("sex");
	String year=req.getParameter("birthday");
	String email=req.getParameter("email");
	String mobile=req.getParameter("mobile");
	String address=req.getParameter("address");
	String veryCode=req.getParameter("veryCode");
	
	HttpSession session = req.getSession();
	//获得系统生成的验证码
	String sysCode = (String)session.getAttribute("syscode");
	EASYBUY_USER u=new EASYBUY_USER(username, name, rePassWord, sex, year, null, email, mobile, address, 1);
	int count=EASYBUY_USERDao.insert(u);
	PrintWriter out=resp.getWriter();
	if(sysCode.equals(veryCode)){
		if(count>0){
			resp.sendRedirect("reg-result.jsp");
		}else{
			out.write("<script>");
			out.write("alert('register error');");
			out.write("location.href='register.jsp'");
			out.write("</script>");
			out.close();
		}
	}
	
	
	}
}
