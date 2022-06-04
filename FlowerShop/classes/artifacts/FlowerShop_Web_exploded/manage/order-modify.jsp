<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
			<li class="current"><a href="ordersel">订单</a></li>
			<li><a href="SelManage">留言</a></li>
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
		<h2>修改订单</h2>
		<div class="manage">
			<form action="douporder">
				<table class="form">
					<tr>
						<td class="field">订单ID：</td>
						<td><input type="text" class="text" name="orderId" value="${order.EO_ID }" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">订购人姓名：</td>
						<td><input type="text" class="text" name="name" value="${order.EO_USER_NAME }" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">收货地址</td>
						<td><input type="text" class="text" name="addres" value="${order.EO_USER_ADDRESS }"  readonly="readonly"/></td>
					</tr>
					<tr>
						<td class="field">总价格</td>
						<td><input type="text" class="text" name="cost" value="${order.EO_COST }" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">订单状态</td>
						<td >
							<select name="tatus" onchange="change(this,${order.EO_STATUS })">
								<option value="1" ${order.orderStatusStr=="待审核" ? "selected" : ""}>待审核</option>
								<option value="2" ${order.orderStatusStr=="审核通过" ? "selected" :""}>审核通过</option>
								<option value="3" ${order.orderStatusStr=="配货" ? "selected" : ""}>配货</option>
								<option value="4" ${order.orderStatusStr=="发货" ? "selected" : ""}>发货</option>
								<option value="5" ${order.orderStatusStr=="收货确认" ? "selected" : ""}>收货确认</option>
							</select>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="main">
		<h2>订单详细</h2>
		<div class="manage">
				<table border="1"  width="600px" height="100px" bordercolor="red">
					<tr align="center">
						<td class="field">商品名称</td>
						<td class="field">商品图片</td>
						<td class="field">商品价格</td>
						<td class="field">购买数量</td>
						<td class="field">商品库存</td>
					</tr>
					<c:forEach var="d" items="${dlist}">
					<tr align="center">
						<td>${d.EP_NAME }</td>
						<td><img src="../images/product/${d.EP_FILE_NAME }"  height="100" width="100"/></td>
						<td>${d.EP_PRICE }</td>
						<td>${d.EOD_QUANTITY }</td>
						<td>${d.EP_STOCK }</td>
					</tr>
					</c:forEach>
				</table>
			</div>	
	  </div>
	<div class="clear"></div>
</div>
<%@ include file="/include/footer.jsp" %>
</body>
</html>
