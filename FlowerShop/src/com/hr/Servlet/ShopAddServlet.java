package com.hr.Servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hr.dao.EASYBUY_PRODUCTDao;
import com.hr.dao.ESDao;
import com.hr.entity.EASYBUY_PRODUCT;
import com.hr.entity.EASYBUY_USER;
import com.hr.entity.eb_shop;

public class ShopAddServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		  es_id           NUMBER primary key not null,--id
//		  es_ep_file_name NVARCHAR2(30),--图片名称
//		  es_ep_name      NVARCHAR2(30),--商品名
//		  es_ep_price     NUMBER,--商品单价
//		  es_eod_quantity NUMBER,--购买数量
//		  es_ep_stock     NUMBER,--商品库存
//		  es_ep_id        NUMBER,--商品id
//		  es_EU_USER_ID   NVARCHAR2(30),--用户id
//		  es_valid	  NUMBER --是否结账，1未结账，2已结账
		EASYBUY_PRODUCT p = null;
		String pid = req.getParameter("id");
		String count = req.getParameter("count");
		if(pid!=null){
			p = EASYBUY_PRODUCTDao.selectById(Integer.parseInt(pid));
		}
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		EASYBUY_USER user=(EASYBUY_USER)session.getAttribute("name");
		
		if(user!=null){
//			System.out.println("登录好了");
			EASYBUY_USER eu=(EASYBUY_USER)session.getAttribute("name");
			String id=(String)eu.getEU_USER_ID();
			ArrayList<eb_shop> list=ESDao.getShop(id);
			req.setAttribute("shoplist",list);
			//req.getRequestDispatcher("shopping.jsp").forward(req, resp);
		}else{
			out.print("<script>");
			out.print("alert('请先登录');");
			out.print("location.href='login.jsp';");
			out.print("</script>");
			out.close();
			return;
		}
		String uid = user.getEU_USER_ID();
		int valid = 1;
		eb_shop sp = new eb_shop(0, p.getEP_FILE_NAME(), p.getEP_NAME(), p.getEP_PRICE(), Integer.parseInt(count), p.getEP_STOCK(), p.getEP_ID(), uid, valid);
		ESDao.insert(sp);
		resp.sendRedirect("ShopSelect");
		//req.getRequestDispatcher("ShopSelect").forward(req, resp);
	}
}
