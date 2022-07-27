<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>無人行動車車--登入</title>


<style>
body{
    background-image: url("678.webp");
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center;
    background-size: cover;
    border:10px solid #B399FF;
    margin:0;
    padding:0;
    
}
header{

	height: 50px;
    text-align: center;
    margin-top: 15px;
}
.header01{
color:black;
font-weight:700;
font-size: 45px;
margin-left: 10;
line-height: 50px;
text-align: center;
animation-duration:5s;
animation-name:header01;
animation-interation-count: infinite;
animation-direction:alternate;
animation-timing-function:ease-in-out;
}
@keyframes header01{
	from{
		opacity:0.1;
	}
	50%{
		opacity: 1;
	}
	to{
		opacity:0.1;
	}
}
.header02{
color:black;
font-weight:700;
font-size: 45px;
margin-left: 10;
line-height: 50px;
text-align: center;	
}
.sb1{
    width:300px;
    margin:5% auto;
    border: 0px solid black;
    padding: 10px;
    border-radius: 10px;
    text-align: center;
    font-weight: 800px;
    font-size: 20px;
}
.sb1 input{
    margin: 5px;
}
.sb2{
    width:70%;
    margin:5% auto;
    padding:20px;
    border-radius: 10px;
    text-align: center;
    margin-top: 200px;
   
}


.sb2 input{
    margin: 5px;
}




</style>

</head>
<body>
<header>
<span class="header01">donkey car登入</span>
</header>
<div class="sb1">
<img src="logo.png" width="300" height="300">

<form action="LoginServlet" method="post">
姓名:<input type="text" name="account"><br>
密碼:<input type="text" name="password"><br>
<input type="submit" value="go"><br>
<a href="register1.jsp">註冊</a>

</form>


</div>