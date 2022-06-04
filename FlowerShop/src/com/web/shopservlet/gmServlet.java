package com.web.shopservlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hr.dao.ESDao;
import com.hr.entity.EASYBUY_ORDER_DETAIL;
import com.hr.entity.EASYBUY_USER;
import com.hr.util.EncodeUtil;


public class gmServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
		throws ServletException, IOException {
	arg1.setContentType("text/html;charset=utf-8");
	PrintWriter out=arg1.getWriter();
	EncodeUtil.encode(arg0);
	HttpSession session=arg0.getSession();
	EASYBUY_USER list=(EASYBUY_USER)session.getAttribute("name");
	//用户id
	String id=list.getEU_USER_ID();
	//用户姓名
	String name=list.getEU_USER_NAME();
	//用户地址
	String address=list.getEU_ADDRESS();
	//总价钱
	String price=arg0.getParameter("jstext");
	////////////////
	//商品id
	String [] EP_ID=arg0.getParameterValues("spID");
	//购买数量
	String [] quantity=arg0.getParameterValues("number");
	//商品单价
	String [] sPPrice=arg0.getParameterValues("sPPrice");
	
	//购买后对商品表的库存进行修改
	for(int i=0;i<EP_ID.length;i++){
		int count5=ESDao.updateStock(Integer.parseInt(quantity[i]),Integer.parseInt(EP_ID[i]));
	}
	//商品单个总价
	int [] pprice=new int[EP_ID.length];
	for(int i=0;i<EP_ID.length;i++){
		pprice[i]=Integer.parseInt(quantity[i])*Integer.parseInt(sPPrice[i]);
	} 
	/////////////////得到序列
	//往订单表里添加数据
	int count=ESDao.insertDD(id, name, address,Integer.parseInt(price));
	int getSequenceId=ESDao.getSequenceId();
	//循环往订单详情添加
	for(int i=0;i<EP_ID.length;i++){
		EASYBUY_ORDER_DETAIL eod=new EASYBUY_ORDER_DETAIL(1,getSequenceId,Integer.parseInt(EP_ID[i]),Integer.parseInt(quantity[i]),pprice[i]);
		int count2=ESDao.eodInsert(eod);
	}
	
	
	////////////////////
	// 开单后，修改购物车
	String [] esID=arg0.getParameterValues("esID");
	for(int i=0;i<esID.length;i++){
		int count3 =ESDao.esdelete(Integer.parseInt(esID[i]));
	}
	/////
	if(count>0){
			
		out.print("<script>");
		out.print("alert('购物成功');");
		out.print("location.href='shopping-result.jsp';");
		out.print("</script>");
		out.close();
	}else{
		out.print("<script>");
		out.print("alert('购物失败，请重新选择商品');");
		out.print("location.href='ShopSelect';");
		out.print("</script>");
		out.close();
	}
}
}
