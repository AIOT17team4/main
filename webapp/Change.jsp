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
<%=htmlLib.SCRIPT_PRODUCE %>
</head>
<body>
<h1>無人行動車車-車車數據</h1>

<%
String account="測試者一號";
try{
account = (String)session.getAttribute("account");
if(account==null){
	account="測試者一號";
}
}catch(Exception e){}


CarDataDAO carDataDAO= new CarDataDAO();
List<CarDataBean> LCD = carDataDAO.selectAllCarData();
%>
<%=htmlLib.HEADER_UL_PRODUCE %>
<form action="ChangeCarDataServlet" >
	
<table>

	<tr>
<th>車車編號</th>
<th>貨物1 增減</th>
<th>貨物2 增減</th>
<th>貨物3 增減</th>
<th>備註</th>
</tr>
<tr>
<td> <input name="carID" type="number">  </td>
<td><input name="cargo1" type="number"></td>
<td><input name="cargo2" type="number"></td>
<td><input name="cargo3" type="number"></td>
<td><input name="note" type="text"></td>


</tr>
<tr>
<td colspan=5> <input type="submit" value="submit">  </td>
</tr>




</table>
</form>

<%=htmlLib.COMMONJS_PRODCE %>

</body>
</html>