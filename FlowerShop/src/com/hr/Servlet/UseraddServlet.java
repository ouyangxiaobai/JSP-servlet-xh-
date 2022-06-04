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
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class UseraddServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	EncodeUtil.encode(req);
	resp.setContentType("text/html;charset=utf-8");
	
	String username=req.getParameter("userName");
	String name=req.getParameter("name");
	String pwd=req.getParameter("passWord");
	String sex=req.getParameter("sex");
//	String birthyear=request.getParameter("birthyear");
//	String birthmonth=request.getParameter("birthmonth");
//	String birthday=request.getParameter("birthday");
	
//	String year=birthyear+"-"+birthmonth+"-"+birthday;
	String year=req.getParameter("birthday");
	String email=req.getParameter("email");
	String mobile=req.getParameter("mobile");
	String address=req.getParameter("address");
	
	EASYBUY_USER u=new EASYBUY_USER(username, name, pwd, sex, year, null, email, mobile, address, 1);
	int count=EASYBUY_USERDao.insert(u);
	PrintWriter out=resp.getWriter();
	if(count>0){
		resp.sendRedirect("manage-result.jsp");
	}else{
		out.write("<script>");
		out.write("alert('添加失败');");
		out.write("location.href='user-add.jsp'");
		out.write("</script>");
		out.close();
	}
}
}
