<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<li class="current"><a href="user">用户</a></li>
			<li><a href="productSelect">商品</a></li>
			<li><a href="ordersel">订单</a></li>
			<li><a href="SelManage">留言</a></li>
			<li><a href="newsselect">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		欢迎回到管理后台。
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
		<h2>用户管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>性别</th>
					<th>Email</th>
					<th>手机</th>
					<th>操作</th>
				</tr>
				<c:forEach var="u" items="${userlist}">
				<tr>
					<td class="first w4 c">${u.EU_USER_ID }</td>
					<td class="w1 c">${u.EU_USER_NAME }</td>
					<td class="w2 c">${u.EU_SEX=='T'?'男':'女'}</td>
					<td>${u.EU_EMAIL }</td>
					<td class="w4 c">${u.EU_MOBILE }</td>
					<td class="w1 c"><a href="userupdate?id=${u.EU_USER_ID }">修改</a><c:if test="${u.EU_STATUS==1}"> <a href="javascript:Delete('${u.EU_USER_ID }');">删除</a></c:if></td>
				</tr>
				</c:forEach>
			</table>
			当前:${cpage }/${tpage }页
			<a href="user?cp=1">首页</a>
			<a href="user?cp=${cpage-1<=0 ?1:cpage-1}">上一页</a>
			<a href="user?cp=${cpage+1>=tpage ? tpage : cpage+1 }">下一页</a>
			<a href="user?cp=${tpage }">尾页</a>
			<select onchange="jump(this.value)">
				<c:forEach var="i" begin="1" end="${tpage}">
					<option ${i==cpage ? "selected" : "" } value="${i}">${i }页</option>
				</c:forEach>
		</select>
		</div>
	</div>
	<div class="clear"></div>
</div>
<%@ include file="/include/footer.jsp" %>
</body>
</html>
