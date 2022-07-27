<%@page import="htmlLib.HtmlLib"%>
<%@page import="beanDAO.ErrorBean"%>
<%@page import="beanDAO.ErrorDAO"%>

<%@page import="java.util.List"%>

<%@page import="jakarta.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>無人行動車車-異常通報列表</title>
<% 
HtmlLib htmlLib=new HtmlLib();
%>
<%=htmlLib.SCRIPT_PRODUCE %>
<%= htmlLib.user_information_produce(session) %>
</head>
<body>


<%
String account="測試者一號";
try{
account = (String)session.getAttribute("account");
if(account==null){
	account="測試者一號";
}
}catch(Exception e){}


ErrorDAO errorDAO= new ErrorDAO();
List<ErrorBean> LEB = errorDAO.selectAllErrorData();
%>
<%= htmlLib.HEADER_UL_PRODUCE  %>
<table>
<tr>
<th>流水號-</th>
<th>名稱</th>
<th>時間</th>
<th>狀態</th>

</tr>
<%
for(ErrorBean EB : LEB){
	out.print("<tr> <td>"+EB.getId()+"</td>");
	out.print("<td>"+EB.getName()+"</td>");
	out.print("<td>"+EB.getTime()+"</td>");
	out.print("<td>"+EB.getStatus()+"</td></tr>");
	
	
} 

%>





</table>

<%=htmlLib.COMMONJS_PRODCE %>


</body>
</html>