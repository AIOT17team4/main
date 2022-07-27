<%@page import="htmlLib.HtmlLib"%>
<%@page import="jakarta.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>無人行動車車-首頁</title>
<% 
HtmlLib htmlLib=new HtmlLib();
%>
<%=htmlLib.SCRIPT_PRODUCE %>
</head>
<body>
<h1>無人行動車車-首頁</h1>

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
<form action="ProblemSetServlet" method="get">
        <table>
            <tr>
                <td>
                    <input type="text" name="name" id="">
                </td>
            </tr>
            <tr>
                <td><textarea name="state" id="" cols="30" rows="10"></textarea></td>
            </tr>
            <tr>
                <td> <textarea name="solution" id="" cols="30" rows="10"></textarea></td>
            </tr>
            <tr>
                <td><input type="submit" name="" id=""></td>
            </tr>

        </table>
    </form>





<%=htmlLib.COMMONJS_PRODCE %>

</body>
</html>