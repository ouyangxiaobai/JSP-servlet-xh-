package com.hr.Servlet;


import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_COMMENTDao;
import com.hr.entity.EASYBUY_COMMENT;

public class GueServlet extends HttpServlet {
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			//编码
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			//2.取值 ----
			String guestName=request.getParameter("guestName");
			// String name=request.getParameter("name");
			String guestContent=request.getParameter("guestContent");
			//把date转为String 
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String time=sdf.format(date).toString();
			//System.out.println(guestContent);
			EASYBUY_COMMENT comment=new EASYBUY_COMMENT(0,guestContent,time,"",null,guestName);
			int num=EASYBUY_COMMENTDao.insert(comment);
			if(num>0){
				  response.sendRedirect("SelallServlet");
			}else{
				response.getWriter().print("<script>alert('添加失败！');history.back();</script>");
			
			}
			
		}
		
	}
