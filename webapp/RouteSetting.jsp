<%@page import="htmlLib.HtmlLib"%>
<%@page import="jakarta.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>無人行動車車-路線設定</title>
<% 
HtmlLib htmlLib=new HtmlLib();
%>
<%=htmlLib.SCRIPT_PRODUCE %>
</head>
<body>
<h1>無人行動車車-路線設定</h1>

<%
String account="測試者一號";
try{
account = (String)session.getAttribute("account");
if(account==null){
	account="測試者一號";
}
}catch(Exception e){}

%>

<%= htmlLib.HEADER_UL_PRODUCE  %>
	
	<form action="" method="post">
	車車選擇
	<select name="carID" id="xxx">
    <option value="1">車車一號</option>
    <option value="2">車車二號</option>
    <option value="3">車車三號</option>
    </select>
    車車路線選擇
    <select name="route" id="xxx">
    <option value="1">一號路線</option>
    <option value="2">二號路線</option>
    <option value="3">三號路線</option>
    </select>
    <input type="submit">
	</form>



<%=htmlLib.COMMONJS_PRODCE %>


</body>
</html>