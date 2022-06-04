<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.hr.entity.EASYBUY_COMMENT"%>
<%@page import="com.hr.dao.EASYBUY_COMMENTDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 花语心情-网上花店</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../indexSelect">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="user">用户</a></li>
			<li><a href="productSelect">商品</a></li>
			<li><a href="ordersel">订单</a></li>
			<li class="current"><a href="SelManage">留言</a></li>
			<li><a href="newsselect">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员${name.EU_USER_ID}您好，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">花语心情-网上花店</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><em><a href="user-add.jsp">新增</a></em><a href="user">用户管理</a></dd>
				<dt>商品信息</dt>
				<dd><em><a href="productClassAdd">新增</a></em><a href="productClass">分类管理</a></dd>
				<dd><em><a href="productAdd">新增</a></em><a href="productSelect">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="ordersel">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="SelManage">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="news-add.jsp">新增</a></em><a href="newsselect">新闻管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>留言管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>留言内容</th>
					<th>状态</th>
					<th>操作</th> 
				</tr>
				<%  
  				 int cpage=(Integer)request.getAttribute("page");
				 int max_page=(Integer)request.getAttribute("max_page"); 
				
				 ArrayList<EASYBUY_COMMENT> list=(ArrayList<EASYBUY_COMMENT>)request.getAttribute("list");
				for(EASYBUY_COMMENT comment:list){
				 %>
				 
				<tr>
					<td class="first w4 c"><%=comment.getEC_ID() %></td>
					<td class="w1 c"><%=comment.getEC_NICK_NAME() %></td>
					<td><%=comment.getEC_CONTENT() %></td>
						<%if(comment.getEC_REPLY()==null || "".equals(comment.getEC_REPLY())) {%>
						<td class="w1 c">未回复</td>
					<%}else{ %>
						<td class="w1 c">已回复</td>
					<%} %>
					<td class="w1 c">
					<%if(comment.getEC_REPLY()==null || "".equals(comment.getEC_REPLY())){ %>
						<a href="UpdateManage?id=<%=comment.getEC_ID()%>">回复</a> 
					<%} %>
						
						<a href="javascript:DelManage(<%=comment.getEC_ID()%>)">删除</a>
					</td>
				</tr>
				<%
				}
				 %>
			</table>
			<div class="pager">
				<ul class="clearfix">
				<% if(cpage!=1){ %>
					<li><a href="SelManage?page=<%=cpage-1%>">上一页</a></li>
				<% }%>
					<%for(int i=1;i<=max_page;i++){ %>
					<li><a href="SelManage?page=<%=i%>"><%=i %></a></li>
					<%} %>
				<%if(cpage!=max_page){ %>
					<li><a href="SelManage?page=<%=cpage+1%>">下一页</a></li>
 
				<%	
				} %>
				</ul>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<%@ include file="/include/footer.jsp" %>
</body>
</html>
