package com.hr.Servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hr.dao.EASYBUY_DdanDao;
import com.hr.dao.EASYBUY_NEWSDao;
import com.hr.dao.EASYBUY_PRODUCTDao;
import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_Ddan;
import com.hr.entity.EASYBUY_NEWS;
import com.hr.entity.EASYBUY_PRODUCT;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import com.hr.util.EncodeUtil;

public class SelectDD extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");
	//查询分类数据
	ArrayList<EASYBUY_PRODUCT_CATEGORY> flist = EASYBUY_PRODUCT_CATEGORYDao.selectFather();
	req.setAttribute("flist", flist);
	ArrayList<EASYBUY_PRODUCT_CATEGORY> clist = EASYBUY_PRODUCT_CATEGORYDao.selectChild();
	req.setAttribute("clist", clist);
	ArrayList<EASYBUY_PRODUCT> tlist = EASYBUY_PRODUCTDao.selectAllByT();
	req.setAttribute("tlist", tlist);
	ArrayList<EASYBUY_PRODUCT> hlist = EASYBUY_PRODUCTDao.selectAllByHot();
	req.setAttribute("hlist", hlist);
	ArrayList<EASYBUY_NEWS> nlist = EASYBUY_NEWSDao.selectAll();
	req.setAttribute("nlist", nlist);
	HttpSession session = req.getSession();
	//查询最近浏览的商品
	ArrayList<Integer> ids = (ArrayList<Integer>)session.getAttribute("ids");
	if(ids!=null){
		ArrayList<EASYBUY_PRODUCT> lastlylist = EASYBUY_PRODUCTDao.selectById(ids);
		req.setAttribute("lastlylist", lastlylist);
	}
	
		EncodeUtil.encode(req);
		String dd=req.getParameter("dd");
		ArrayList<EASYBUY_Ddan> dan=EASYBUY_DdanDao.selectById(dd);
		req.setAttribute("dan", dan);
		req.getRequestDispatcher("Dan.jsp").forward(req, resp);
}
}
