<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>花语心情-网上花店 - 聊天室</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript">
function setReceiver(obj)
{
	document.getElementById("reply-to").innerHTML = "接收人：" + obj.innerHTML;
}
</script>
</head>
<body>
<div id="chat-room">
	<div class="lefter">
		<h2>在线用户列表</h2>
		<ul>
			<li><a href="#" onclick="setReceiver(this);">张三</a></li>
		</ul>
	</div>
	<div class="righter">
		<div id="history">
			<p>aaa</p>
			<p>aaa</p>
		</div>
		<div class="spacer"></div>
		<div id="reply-to">接收人：所有</div>
		<div class="reply">
			<input type="text" class="text" name="content" /><label class="ui-blue"><input type="button" value="发送" /></label>
		</div>
	</div>
</div>
</body>
</html>
