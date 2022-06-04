// JavaScript Document
function Delete(id)
{
	if(confirm("确定要删除吗？")) {
		location.href = "userdel?id=" + id;
	}
}
function Delete2(id)
{
	if(confirm("确定要删除吗？")) {
		location.href = "delnews?id=" + id;
	}
}
function DeleteOder(id)
{
	if(confirm("确定要删除吗？")) {
		location.href = "delorder?id=" + id;
	}
}
function DelManage(id){
	if(confirm("确定要删除吗？")) {
		location.href = "DelManage?id=" + id;
	}
}
function productDel(id){
	if(confirm("确定要删除吗？")) {
		location.href = "productDel?id=" + id;
	}
}
function productClassDel(id){
	if(confirm("确定要删除吗？")) {
		location.href = "productClassDel?id=" + id;
	}
}
var ajax;
function check(name){
	if(window.XMLHttpRequest){
		ajax=new XMLHttpRequest();
	}else if(window.ActiveXObject){
		ajax=new ActiveXObject();
		}
	var url="checkName?name="+encodeURI(name)+"&"+new Date().getTime();
	ajax.open("get",url,true);
	ajax.send();
	ajax.onreadystatechange=check2;
}
function check2(){
	if(ajax.readyState==4 && ajax.status==200){
	var str=ajax.responseText;
	document.getElementById("sp").style.display="inline";
		if(str=='false'){
			document.getElementById("sp").innerHTML="<font color='red'>此用户名不可使用</font>";
			document.getElementById("sb").disabled=true;
		}else{
			document.getElementById("sp").innerHTML="<font color='green'>恭喜可以使用</font>";
			document.getElementById("sb").disabled=false;
		}
	}
}


function jump(p){
	  location.href='user?cp='+p;
}
function jumpnews(pp){
	  location.href='newsselect?cp='+pp;
}
function jumporder(o,orderId,userName){
	  location.href='ordersel?cp='+o+"&orderId="+orderId+"&userName="+userName;
}
function change(sel,sta){
	if(parseInt(sel.value)<sta){
		alert('状态不可回退');
		sel.selectedIndex = sta-1;
	}
}


