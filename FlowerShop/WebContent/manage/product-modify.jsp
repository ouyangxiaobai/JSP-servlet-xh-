<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 花语心情-网上花店</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
<script type="text/javascript">
function check() {
	var num=parseInt(document.getElementById("y").value);
	if(num<0){
		document.getElementById("yy").innerHTML="<font color='red'>价格不能为负数</font>";
		document.getElementById("sub").disabled=true;
	}else{
		document.getElementById("yy").innerHTML="";
		document.getElementById("sub").disabled=false;
	}
}  
function check2() {
	var num=parseInt(document.getElementById("k").value);
	if(num<0){
		document.getElementById("kk").innerHTML="<font color='red'>库存不能为负数</font>";
		document.getElementById("sub").disabled=true;
	}else{
		document.getElementById("kk").innerHTML="";
		document.getElementById("sub").disabled=false;
	}
} 
</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../indexSelect">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="user">用户</a></li>
			<li class="current"><a href="productSelect">商品</a></li>
			<li><a href="ordersel">订单</a></li>
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
		<h2>添加商品</h2>
		<div class="manage">
			<form action="doProductUpdate" method="post" enctype="multipart/form-data">
				<table class="form">
					<tr>
						<td class="field">商品名称：</td>
						<td><input type="text" class="text" name="productName"  value="${p.EP_NAME }"/></td>
						<td><input type="hidden" name="id" value="${p.EP_ID }"/></td>
					</tr>
					<tr>
						<td class="field">所属分类：</td>
						<td>
							<select name="parentId">
								<c:forEach var="f" items="${flist}">
									<option value="${f.EPC_ID }" disabled="disabled">${f.EPC_NAME }</option>
									<c:forEach var="c" items="${clist}">
										<c:if test="${f.EPC_ID==c.EPC_PARENT_ID}">
											<c:if test="${p.EPC_CHILD_ID==c.EPC_ID}">
												<option value="${f.EPC_ID }-${c.EPC_ID }" selected="selected">&nbsp;&nbsp;${c.EPC_NAME }</option>
											</c:if>
											<c:if test="${p.EPC_CHILD_ID!=c.EPC_ID}">
												<option value="${f.EPC_ID }-${c.EPC_ID }">&nbsp;&nbsp;${c.EPC_NAME }</option>
											</c:if>
										</c:if>
									</c:forEach>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">商品图片：</td>
						<td><input type="file" class="text" name="photo" value="${p.EP_FILE_NAME }"/></td>
					</tr>
					<tr>
						<td class="field">商品价格：</td>
						<td><input type="text" class="text tiny" name="productPrice" value="${p.EP_PRICE }" onblur="check()" id="y"/> 元<span id="yy"></span></td>
					</tr>
					<tr>
						<td class="field">描述：</td>
						<td><input type="text" class="text" name="productDesc" value="${p.EP_DESCRIPTION }"/></td>
					</tr>
					<tr>
						<td class="field">库存：</td>
						<td><input type="text" class="text tiny" name="productStock" value="${p.EP_STOCK }" onblur="check2()" id="k"/><span id="kk"></span></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="修改" id="sub"/></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<%@ include file="/include/footer.jsp" %>
</body>
</html>

