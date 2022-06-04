package com.hr.Servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hr.dao.EASYBUY_NEWSDao;
import com.hr.dao.EASYBUY_PRODUCTDao;
import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_NEWS;
import com.hr.entity.EASYBUY_PRODUCT;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;

public class IndexSelectServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
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
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
