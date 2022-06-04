<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>花语心情-网上花店 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript">
function selectname(){
	  var name = document.getElementById("selectname").value;
	  location.href='selectProductList?name='+name;
}
function searchHot(name){
	location.href='selectProductList?name='+name;
}
</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><c:if test="${name!=null}"><a href="selectdd?dd=${name.EU_USER_ID }">个人订单</a></c:if><c:if test="${name!=null}">当前用户${name.EU_USER_ID }</c:if><a href="ShopSelect" class="shopping">购物车</a><c:if test="${name==null}"><a href="login.jsp">登录</a>|<a href="register.jsp">注册</a></c:if><c:if test="${name!=null}"><a href="zx">退出</a></c:if><a href="SelallServlet">留言</a><c:if test="${name.EU_STATUS==2}"><a href="manage/index.jsp" >去后台</a></c:if></div>
	<div class="navbar">
		<ul class="clearfix">
			<c:choose>
			<c:when test="${empty selected_fid}">
			<li class="current" ><a href="indexSelect">首页</a></li>
			</c:when>
			<c:otherwise>
			<li ><a href="indexSelect">首页</a></li>
			</c:otherwise>
			</c:choose>
			<c:forEach var="f" items="${flist}">
			<c:choose>
			<c:when test="${selected_fid == f.EPC_ID}">
			<li class="current" ><a href="selectProductList?fid=${f.EPC_ID }">${f.EPC_NAME }</a></li>
			</c:when>
			<c:otherwise>
			<li><a href="selectProductList?fid=${f.EPC_ID }">${f.EPC_NAME }</a></li>
			</c:otherwise>
			</c:choose>
			</c:forEach>
		</ul>
	</div>
</div>
<%@ include file="/include/search_bar.jsp" %>
<div id="position" class="wrap">
	您现在的位置：<a href="indexSelect">花语心情-网上花店</a> &gt; 阅读新闻
</div>
<div id="main" class="wrap">
	<div class="left-side">
		<div class="news-list">
			<h4>新闻动态</h4>
				<ul>
					<c:forEach var="n" items="${nlist}">
						<li><a href="newsSelect2?id=${n.EN_ID }" target="_blank">${n.EN_TITLE }</a></li>
					</c:forEach>
				</ul>
		</div>
		<div class="spacer"></div>
	</div>
	<div id="news" class="right-main">
		<h1>${n.EN_TITLE }</h1>
		<div class="content">
			<c:out value="${n.EN_CONTENT }"></c:out>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2019 花语心情-网上花店 All Rights Reserved. 沪ICP备案000001号
</div>
</body>
</html>
