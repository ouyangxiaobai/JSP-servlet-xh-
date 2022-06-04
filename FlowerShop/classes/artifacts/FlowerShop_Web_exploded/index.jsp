<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>花语心情-网上花店 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
<style>
.scroll_div {width:600px; height:62px;margin:0 auto; overflow: hidden; white-space: nowrap; background:#ffffff;}
.scroll_div img {width:120px;height:60px;border: 0;margin: auto 8px; border:1px #efefef solid;}
#scroll_begin, #scroll_end, #scroll_begin ul, #scroll_end ul, #scroll_begin ul li, #scroll_end ul li{display:inline;}
</style>
<style>
.scroll_div {width:500px; height:100px;margin:0 auto; overflow: hidden; white-space: nowrap; background:#ffffff;}
.scroll_div img {width:120px;height:100px;border: 0;margin: auto 8px; border:1px #efefef solid;}
#scroll_begin, #scroll_end, #scroll_begin ul, #scroll_end ul, #scroll_begin ul li, #scroll_end ul li{display:inline;}
</style>
<script language="javascript">

function ScrollImgLeft(){
var speed=20
var scroll_begin = document.getElementById("scroll_begin");
var scroll_end = document.getElementById("scroll_end");
var scroll_div = document.getElementById("scroll_div");
scroll_end.innerHTML=scroll_begin.innerHTML
function Marquee(){
    if(scroll_end.offsetWidth-scroll_div.scrollLeft<=0)
      scroll_div.scrollLeft-=scroll_begin.offsetWidth
    else
      scroll_div.scrollLeft++
}
var MyMar=setInterval(Marquee,speed)
scroll_div.onmouseover=function() {clearInterval(MyMar)}
scroll_div.onmouseout=function() {MyMar=setInterval(Marquee,speed)}
}
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
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
				<dt><a href="selectProductList">全部商品</a></dt>
				<c:forEach var="f" items="${flist}">
					<dt><a href="selectProductList?fid=${f.EPC_ID }">${f.EPC_NAME }</a></dt>
					<c:forEach var="c" items="${clist}">
						<c:if test="${f.EPC_ID==c.EPC_PARENT_ID}">
							<c:if test="${p.EPC_CHILD_ID!=c.EPC_ID}">
								<dd><a href="selectProductList?cid=${c.EPC_ID }">${c.EPC_NAME }</a></dd>
							</c:if>
						</c:if>
					</c:forEach> 
				</c:forEach> 
			</dl>
		</div>
		<div class="spacer"></div>
		<div class="last-view">
			<h2>最近浏览</h2>
			<dl class="clearfix">
				<c:forEach var="lastp" items="${lastlylist}">
					<dt><a href="selectProductView?id=${lastp.EP_ID }"><img height="40" src="images/product/${lastp.EP_FILE_NAME }" /></a></dt>
					<dd><a href="selectProductView?id=${lastp.EP_ID }">${lastp.EP_NAME }</a></dd>
				</c:forEach>
			</dl>
		</div>
	</div>
	
<div class="main">
<div class="price-off" style="width: 770px;">
    <!--#####滚动区域#####-->
    <div id="scroll_div" class="scroll_div" style="width: 770px;">
      <div id="scroll_begin">
        <ul>
       	  <c:forEach var="tp" items="${tlist}">
          <li><a href="selectProductView?id=${tp.EP_ID }"><img  src="images/product/${tp.EP_FILE_NAME }" /></a></li>
          </c:forEach>
        </ul>
      </div>
      <div id="scroll_end"></div>
    </div>
    <!--#####滚动区域#####-->
</div>
<script type="text/javascript">ScrollImgLeft();</script>
</div>
	<div class="main">
		<div class="price-off">
			<h2>今日特价</h2>
			<ul class="product clearfix">
				<c:forEach var="tp" items="${tlist}">
					<li>
						<dl>
							<dt><a href="selectProductView?id=${tp.EP_ID }" target="_blank"><img src="images/product/${tp.EP_FILE_NAME }" /></a></dt>
							<dd class="title"><a href="selectProductView?id=${tp.EP_ID }" target="_blank">${tp.EP_DESCRIPTION }</a></dd>
							<dd class="price">${tp.EP_PRICE }.00</dd>
						</dl>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="side">
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
		<div class="spacer clear"></div>
		<div class="hot">
			<h2>热卖推荐</h2>
			<ul class="product clearfix">
				<c:forEach var="hotp" items="${hlist}">
					<li>
						<dl>
							<dt><a href="selectProductView?id=${hotp.EP_ID }" target="_blank"><img src="images/product/${hotp.EP_FILE_NAME }" /></a></dt>
							<dd class="title"><a href="selectProductView?id=${hotp.EP_ID }" target="_blank">${hotp.EP_DESCRIPTION}</a></dd>
							<dd class="price">${hotp.EP_PRICE }.00</dd>
						</dl>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2019 花语心情-网上花店 All Rights Reserved. 沪ICP备案000001号
</div>
</body>
</html>


