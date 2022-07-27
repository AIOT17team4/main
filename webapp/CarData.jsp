<%@page import="htmlLib.HtmlLib"%>
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
<title>無人行動車車-車車數據</title>
<% 
HtmlLib htmlLib=new HtmlLib();
%>
<%=htmlLib.SCRIPT_PRODUCE%>
	
</head>
<body>

<%

CarDataDAO carDataDAO= new CarDataDAO();
List<CarDataBean> LCD = carDataDAO.selectAllCarData();
%>


<%= htmlLib.HEADER_UL_PRODUCE  %>
<%= htmlLib.user_information_produce(session) %>


	
<table class="table-striped">
<tr>
<th>流水號</th>
<th>車車編號</th>
<th>車車位置</th>
<th>貨物1</th>
<th>貨物2</th>
<th>貨物3</th>
<th>更動時間</th>
<th>備註</th>
</tr>
<%
for(CarDataBean CDB : LCD){
	out.print("<tr> <td>"+CDB.getId()+"</td>");
	out.print("<td>"+CDB.getCarID()+"</td>");
	out.print("<td>"+CDB.getPlace()+"</td>");
	out.print("<td>"+CDB.getCargo1()+"</td>");
	out.print("<td>"+CDB.getCargo2()+"</td>");
	out.print("<td>"+CDB.getCargo3()+"</td>");
	out.print("<td>"+CDB.getTimeDate()+"</td>");
	out.print("<td>"+CDB.getNote()+"</td> </tr>");
} 

%>


</table>

<%=htmlLib.COMMONJS_PRODCE %>
</body>
</html>