package com.hr.Servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_USERDao;
import com.hr.entity.EASYBUY_USER;
import com.hr.util.EncodeUtil;

public class UserDoupdate extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		EncodeUtil.encode(req);
		resp.setContentType("text/html;charset=utf-8");
		String username=req.getParameter("userName");
		String name=req.getParameter("name");
		String pwd=req.getParameter("passWord");
		String sex=req.getParameter("sex");
		String birthday=req.getParameter("birthday");
		String email=req.getParameter("email");
		String mobile=req.getParameter("mobile");
		String address=req.getParameter("address");
		String userStatus=req.getParameter("userStatus");
		int status = 1;
		if(userStatus != null && !"".equals(userStatus)){
			status = Integer.parseInt(userStatus);
		}
		EASYBUY_USER user=new EASYBUY_USER(username, name, pwd, sex, birthday, null, email, mobile, address, status);
		int count=EASYBUY_USERDao.update(user);
		if(count>0){
			resp.sendRedirect("manage-result.jsp");
		}else{
			PrintWriter out=resp.getWriter();
			out.print("<script>");
			out.print("alert('修改失败');");
			out.print("location.href='user'");
			out.print("</script>");
			out.close();
		}
	}
}
