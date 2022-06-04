package com.hr.Servlet;


import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EASYBUY_ORDERDao;
import com.hr.entity.EASYBUY_ORDER;
import com.hr.util.EncodeUtil;

public class OrderSelServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		int cpage=1;
		int count=10;
		EncodeUtil.encode(req);
		String cp=req.getParameter("cp");
		String id=req.getParameter("orderId");
		String name=req.getParameter("userName");
		name = name==null ? "" : name;
		if(cp!=null){
			cpage=Integer.parseInt(cp);
		}
		int tpage=EASYBUY_ORDERDao.totalPage(count,id,name);
		ArrayList<EASYBUY_ORDER> order=EASYBUY_ORDERDao.selectAll(cpage,count,id,name);
		req.setAttribute("order", order);
		req.setAttribute("cpage", cpage);
		req.setAttribute("tpage", tpage);
		req.setAttribute("orderId", id);
//		System.out.println(name+"----"+URLEncoder.encode(name,"utf-8"));
		req.setAttribute("userName", URLEncoder.encode(name,"utf-8"));
		req.getRequestDispatcher("order.jsp").forward(req, resp);
}
}
