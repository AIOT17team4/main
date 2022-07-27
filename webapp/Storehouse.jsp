<%@page import="htmlLib.HtmlLib"%>
<%@page import="beanDAO.StorehouseDAO"%>
<%@page import="beanDAO.StorehouseBean"%>
<%@page import="beanDAO.CarDataBean"%>
<%@page import="java.util.List"%>
<%@page import="beanDAO.CarDataDAO"%>
<%@page import="jakarta.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>無人行動車車-倉庫紀錄</title>
<% 
HtmlLib htmlLib=new HtmlLib();
%>
<%=htmlLib.SCRIPT_PRODUCE %>
</head>
<body>

<%
StorehouseDAO storehouseDAO= new StorehouseDAO();
List<StorehouseBean> LSB =storehouseDAO.selectAllData();
%>
<%= htmlLib.HEADER_UL_PRODUCE  %>
<%= htmlLib.user_information_produce(session) %>
<table>
<tr>
<th>流水號</th>
<th>進貨倉庫</th>
<th>出貨倉庫</th>
<th>貨物1 </th>
<th>貨物2 </th>
<th>貨物3 </th>
<th>更動時間 </th>

</tr>
<%
for(StorehouseBean SB : LSB){
	out.print("<tr> <td>"+SB.getId()+"</td>");
	out.print("<td>"+SB.getGoIn()+"</td>");
	out.print("<td>"+SB.getCargo4()+"</td>");
	out.print("<td>"+SB.getCargo1()+"</td>");
	out.print("<td>"+SB.getCargo2()+"</td>");
	out.print("<td>"+SB.getCargo3()+"</td>");
	out.print("<td>"+SB.getTime()+"</td></tr>");

} 

%>





</table>

<%=htmlLib.COMMONJS_PRODCE %>


</body>
</html>