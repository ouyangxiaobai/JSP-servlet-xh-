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

public class LoginServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String username=req.getParameter("userName");
		String passWord=req.getParameter("passWord");
		String veryCode=req.getParameter("veryCode");
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession();
		//获得系统生成的验证码
		String sysCode = (String)session.getAttribute("syscode");
		int count=EASYBUY_USERDao.selectByNM(username, passWord);
		EASYBUY_USER user=EASYBUY_USERDao.selectAdmin(username, passWord);
		if(sysCode.equals(veryCode)){
			if(count>0){
				session.setAttribute("name", user);
				if(user.getEU_STATUS()==2){
					//System.out.println(user.getEU_STATUS());
					//resp.sendRedirect("manage/index.jsp");
					resp.sendRedirect("manage/index.jsp");
				}else{
					resp.sendRedirect("indexSelect");
				}
			}else{
				PrintWriter out = resp.getWriter();
				out.print("<script>");
				out.print("alert('用户名或密码错误');");
				out.print("location.href='login.jsp';");
				out.print("</script>");
				out.close();
			}
		}else{
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('验证码错误');");
			out.print("location.href='login.jsp';");
			out.print("</script>");
			out.close();
		}
	}
}
