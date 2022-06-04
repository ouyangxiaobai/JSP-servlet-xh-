<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="javascript:searchHot('玫瑰')">玫瑰</a></li>
			<li><a href="javascript:searchHot('百合')">百合</a></li>
			<li><a href="javascript:searchHot('康乃馨')">康乃馨</a></li>
			<li><a href="javascript:searchHot('菊花')">菊花</a></li>
			<li><a href="javascript:searchHot('八角叶')">八角叶</a></li>
			<li><a href="javascript:searchHot('绿萝')">绿萝</a></li>
			<li><a href="javascript:searchHot('多肉')">多肉</a></li>
			<li><a href="javascript:searchHot('蝴蝶兰')">蝴蝶兰</a></li>
			<li><a href="javascript:searchHot('紫罗兰')">紫罗兰</a></li>
			<li><a href="javascript:searchHot('茉莉花')">茉莉花</a></li>
			<li><a href="javascript:searchHot('栀子花')">栀子花</a></li>
			<li><a href="javascript:searchHot('曼陀罗')">曼陀罗</a></li>
			<li><a href="javascript:searchHot('马蹄莲')">马蹄莲</a></li>
			<li class="last"><input type="text" id="selectname" value="${search_words }" /><a href="javascript:selectname()" >&nbsp;&nbsp;搜索</a></li>
		</ul>
	</div>
</div>