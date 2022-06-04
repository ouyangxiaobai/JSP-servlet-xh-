package com.web.shopservlet;


//订单表数据的查询

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.hr.dao.ESDao;
import com.hr.entity.EASYBUY_USER;
import com.hr.entity.eb_shop;
import com.hr.util.EncodeUtil;

public class ShopSelect extends HttpServlet {
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		EncodeUtil.encode(arg0);
		arg1.setContentType("text/html;charset=utf-8");
		PrintWriter out = arg1.getWriter();
		HttpSession session=arg0.getSession();
		EASYBUY_USER userCZ=(EASYBUY_USER)session.getAttribute("name");
		if(userCZ!=null){
//			System.out.println("登录好了");
			EASYBUY_USER eu=(EASYBUY_USER)session.getAttribute("name");
			String id=(String)eu.getEU_USER_ID();
			ArrayList<eb_shop> list=ESDao.getShop(id);
			arg0.setAttribute("shoplist",list);
			arg0.getRequestDispatcher("shopping.jsp").forward(arg0, arg1);
		}else{
			out.print("<script>");
			out.print("alert('请先登录');");
			out.print("location.href='login.jsp';");
			out.print("</script>");
			out.close();
			
		}
	}
}
