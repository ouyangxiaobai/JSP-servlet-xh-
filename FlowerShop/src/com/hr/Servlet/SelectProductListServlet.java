package com.hr.Servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hr.dao.EASYBUY_PRODUCTDao;
import com.hr.dao.EASYBUY_PRODUCT_CATEGORYDao;
import com.hr.entity.EASYBUY_PRODUCT;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import com.hr.util.EncodeUtil;

public class SelectProductListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		EncodeUtil.encode(req);
		ArrayList<EASYBUY_PRODUCT_CATEGORY> flist = EASYBUY_PRODUCT_CATEGORYDao.selectFather();
		req.setAttribute("flist", flist);
		ArrayList<EASYBUY_PRODUCT_CATEGORY> clist = EASYBUY_PRODUCT_CATEGORYDao.selectChild();
		req.setAttribute("clist", clist);
		HttpSession session = req.getSession();
		//查询最近浏览的商品
		ArrayList<Integer> ids = (ArrayList<Integer>)session.getAttribute("ids");
		if(ids!=null){
			ArrayList<EASYBUY_PRODUCT> lastlylist = EASYBUY_PRODUCTDao.selectById(ids);
			req.setAttribute("lastlylist", lastlylist);
		}
		
		int cpage = 1;//当前页数
		int count = 8;//每页行数
		String cp = req.getParameter("cp");
		if(cp!=null){//如果页面上传递了页数,将当前页数改变掉
			cpage = Integer.parseInt(cp);
		}
		//查出总页数
		int tpage = 0;
		String fid = req.getParameter("fid");
		String cid = req.getParameter("cid");
		String name = req.getParameter("name");
		ArrayList<EASYBUY_PRODUCT> list = null;
		if(fid==null&&cid==null){
			list = EASYBUY_PRODUCTDao.selectAll(cpage, count);
			req.setAttribute("title", "全部商品");
			tpage = EASYBUY_PRODUCTDao.totalPage(count);
		}
		if(fid!=null){
			int id = Integer.parseInt(fid);
			list = EASYBUY_PRODUCTDao.selectAllByFid(cpage, count, id);
			tpage = EASYBUY_PRODUCTDao.totalPageByFid(count, id);
			req.setAttribute("title", EASYBUY_PRODUCT_CATEGORYDao.selectById(id).getEPC_NAME());
		}
		if(cid!=null){
			int id = Integer.parseInt(cid);
			list = EASYBUY_PRODUCTDao.selectAllByCid(cpage, count, id);
			tpage = EASYBUY_PRODUCTDao.totalPageByCid(count, id);
			req.setAttribute("title", EASYBUY_PRODUCT_CATEGORYDao.selectById(id).getEPC_NAME());
		}
		if(name!=null){
			list = EASYBUY_PRODUCTDao.selectAllByName(name);
			tpage = EASYBUY_PRODUCTDao.totalPageByName(count, name);
			req.setAttribute("title", "搜索商品："+name);
		} 
		req.setAttribute("list", list);
		//当前页数
		req.setAttribute("cpage", cpage);
		//总页数
		req.setAttribute("tpage", tpage);
		//搜索关键字
		req.setAttribute("search_words", name);
		//父分类
		req.setAttribute("selected_fid", fid);
		req.getRequestDispatcher("product-list.jsp").forward(req, resp);
	}
}
