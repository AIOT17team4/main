<%@page import="beanDAO.UserBean"%>
<%@page import="htmlLib.HtmlLib"%>
<%@page import="jakarta.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
  <!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>無人行動車車-首頁</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script> -->
    <style>
        body {
            margin: 0;
            background-color: whitesmoke;
        }


        .title {
            font-size: 40px;
            font-weight: 700;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            height: 60px;
            line-height: 60px;
            transition: 2s;
            width: 500px;
            position: relative;
            left: -30%;
        }



        .language img {
            height: 30px;
            position: relative;
            top: 1px;
        }

        .side {
            background-color: rgb(38, 38, 38);
            width: 15vw;
            float: left;
            height: 200vh;
            /* position: absolute ; */
            left: 0px;
            /* opacity:0.5 */
            transition: 0.5s;

        }

        .side ul {
            color: rgb(249, 249, 249);
            margin: 0;
            padding: 0;
            position: fixed;
        }

        .side a {
            color: rgb(249, 249, 249);
        }

        .side li {
            list-style-type: none;
            margin: 20px;
        }

        .out li img {
            height: 16px;
            margin-bottom: 4px;
        }

        header {
            /* text-align: center; */
            background-color: white;
            height: 10vh;
            line-height: 60px;

        }

        .header_ul {
            display: flex;
            float: right;
        }

        .header_ul img {
            height: 40px;
            border-radius: 10px;
        }

        .header_ul li {
            list-style-type: none;
            margin-right: 10px;
        }

        .container1 {
            /* border: 1px solid black; */
            height: 90vh;
            width: 80vw;
            margin: 20px;
            border-collapse: separate;
            border-spacing: 20px;
        }

        .container_th1 {
            width: 60%;
        }

        .container_th2 {
            width: 35%;
        }

        .main {
            margin: 3px;
            /* border: 1px solid blue; */
            border-radius: 10px;
            height: 100%;
            width: 95%;
            background-color: white;
            text-align: center;

        }

        .container1 td {
            width: 550px;
            height: 360px
        }


        .in {
            position: absolute;
            margin: 2px;
            padding: 0%;
        }

        .in li {
            list-style-type: none;

        }

        .out span {

            border-radius: 3px;
            padding: 2px;
        }

        .out .wcar {
            background-color: black;
        }

        .td_fieldset legend {
            text-align: left;
            margin-left: 10%
        }

        .td_fieldset td {
            height: auto;
        }

        .td_fieldset table {
            width: 80%;
            text-align: center;
            margin: auto;
        }

        .td_fieldset th {
            text-align: center;
            border: 1px solid black;
        }
    </style>
    <style>
        /* td2 user list CSS setting */
        .user_list {
            width: 100%;
            max-height: 100%;
            /* border: 1px solid red; */
        }

        .user_list td {
            /* border: 1px solid black; */
            height: auto;

        }

        .user_list img {
            border-radius: 100%;
            border: 1px solid black;
        }
    </style>
    <style>
        /* map CSS setting */
        .map_div {
            background-image: url(dicarimg/map.jpg);
            width: 500px;
            height: 388px;
            background-size: contain;
            background-repeat: no-repeat;
            border: 1px solid red;
            opacity: 0.8;
            margin: auto;
            border-radius: 20px;
        }

        .map_table {
            width: 100%;
            height: 100%;
        }

        .map_table td {
            width: 64px;
            height: 57px;
        }
    </style>
</head>

<body>





    <div class="side">
        <ul class="out">
            <li> <span class="sideButton"><img src="icon/menu.png" alt=""> </span>歡迎</li>
            <li><img src="icon/home.png" alt=""><a href="Home.jsp"> <span>首頁</span>
                </a></li>
            <li><img src="icon/introduction.png" alt=""><a href="Introduction.jsp"><span>dicar介紹</span></a></li>
            <li><img src="icon/car.png" alt=""><a href="CarData.jsp"><span>貨櫃車系統</span></a></li>
            <li><img src="icon/storehouse.png" alt=""><a href="Storehouse.jsp"><span>倉儲系統</span></a></li>
            <li><img src="icon/error.png" alt=""><a href="ErrorList.jsp"><span>異常通報紀錄</span></a></li>
            <li><img src="icon/camera.png" alt=""><a href="Camera.jsp"><span>即時影線監控</span></a></li>
            <li><a href=""><span></span></a></li>
            <li><a href=""><span></span></a></li>
            <li><a href=""><span></span></a></li>
            <li> _ </li>
            <li> <span class="language"> <img src="icon/language.png" alt="">
                    <select name="language" id="language">
                        <option value="default">Language</option>
                        <option value="Ch">中文</option>
                        <option value="En">English</option>
                    </select>
                </span></li>
            <li> <img src="icon/logout.png" alt=""><a href=""> <span> 登出</span></a></li>
        </ul>

    </div>
    <ul class="in" style="display: none;">
        <li style="background-color: black; "><img style="height: 20px;" src="icon/menu.png" alt=""></li>
    </ul>
    <div class="div_header">

        <header>
            <span class="title">
                <img class="img_dicar logo" src="dicarimg/dicar001.png" style="max-height: 95%; border-radius: 25px;"
                    alt="">
            </span>

            <ul class="header_ul">
            </ul>

        </header>
    </div>
    <table class="container1">
        <tr>
            <th class="container_th1">
                <div class="main td1">
                    <fieldset class="td_fieldset">
                        <legend>即時位置</legend>

                        <div class="map_div">
                            <table class="map_table">
                                <tr class="tr_num1">
                                    <td class="td_num1"></td>
                                    <td class="td_num2"></td>
                                    <td class="td_num3"></td>
                                    <td class="td_num4"></td>
                                    <td class="td_num5"></td>
                                    <td class="td_num6 car1p0"></td>
                                    <td class="td_num7 car2p0"></td>
                                    <td class="td_num8"></td>
                                </tr>
                                <tr class="tr_num2">
                                    <td class="td_num1"></td>
                                    <td class="td_num2"></td>
                                    <td class="td_num3"></td>
                                    <td class="td_num4"></td>
                                    <td class="td_num5"></td>
                                    <td class="td_num6"></td>
                                    <td class="td_num7"></td>
                                    <td class="td_num8"></td>
                                </tr>
                                <tr class="tr_num3">
                                    <td class="td_num1 car1p2"></td>
                                    <td class="td_num2"></td>
                                    <td class="td_num3"></td>
                                    <td class="td_num4"></td>
                                    <td class="td_num5"></td>
                                    <td class="td_num6"></td>
                                    <td class="td_num7"></td>
                                    <td class="td_num8"></td>
                                </tr>
                                <tr class="tr_num4">
                                    <td class="td_num1 car2p2"></td>
                                    <td class="td_num2"></td>
                                    <td class="td_num3"></td>
                                    <td class="td_num4"></td>
                                    <td class="td_num5"></td>
                                    <td class="td_num6"></td>
                                    <td class="td_num7"></td>
                                    <td class="td_num8"></td>
                                </tr>
                                <tr class="tr_num5">
                                    <td class="td_num1"></td>
                                    <td class="td_num2"></td>
                                    <td class="td_num3"></td>
                                    <td class="td_num4"></td>
                                    <td class="td_num5"></td>
                                    <td class="td_num6"></td>
                                    <td class="td_num7"></td>
                                    <td class="td_num8"></td>
                                </tr>
                                <tr class="tr_num6">
                                    <td class="td_num1"></td>
                                    <td class="td_num2"></td>
                                    <td class="td_num3"></td>
                                    <td class="td_num4"></td>
                                    <td class="td_num5"></td>
                                    <td class="td_num6 car1p1"></td>
                                    <td class="td_num7 car2p1"> </td>
                                    <td class="td_num8 "></td>
                                </tr>
                            </table>
                            <input type="button" name="" id="" class="button_r" value="red">
                            <input type="button" name="" id="" class="button_g" value="green">
                        </div>

                    </fieldset>
                </div>
            </th>
            <th class="container_th2">
                <div class="main td2">
                    <fieldset class="td_fieldset">
                        <legend>管理者</legend>

                        <table class="user_list">
                            <thead>
                                <tr>
                                    <th colspan="2" style="width: 40%;">ID</th>

                                    <th>上次登入時間</th>
                                </tr>
                            </thead>
                            <tbody>
                                <!-- <tr>
                                    <td><img src="head/head01.png" height="40px" alt=""></td>
                                    <td>有貝爾來</td>
                                    <td>2022-07-11-12:15</td>
                                </tr>-->

                            </tbody>
                        </table>
                    </fieldset>
                </div>
            </th>
        </tr>
        <tr>
            <td>
                <div class="main td3">
                    <fieldset class="td_fieldset">
                        <legend>庫存資訊</legend>
                        <table>
                            <thead>
                                <tr>
                                    <th style="width: 10%;"></th>
                                    <th style="width: 25%;">即時位置</th>
                                    <th style="width: 16%;">紅積木</th>
                                    <th style="width: 16%;">綠積木</th>
                                    <th style="width: 16%;">藍積木</th>
                                    <th style="width: 16%;">黃積木</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>綠車</td>
                                    <td>1號位置</td>
                                    <td>2</td>
                                    <td>1</td>
                                    <td>3</td>
                                    <td>2</td>
                                </tr>
                            </tbody>
                        </table>
                    </fieldset>

                </div>
            </td>
            <td>
                <div class="main td4">
                    <fieldset class="td_fieldset">
                        <legend>異常通報</legend>
                        <table>
                            <thead>
                                <tr>
                                    <th style="width: 25%;">異常內容</th>
                                    <th style="width: 45%;">時間</th>
                                    <th style="width: 25%;">狀態</th>
                                </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                    </fieldset>
                </div>
            </td>
        </tr>


    </table>
      

    <%HtmlLib htmlLib=new HtmlLib();%>
    
    <%=htmlLib.user_arr_produce() %>
    <%=htmlLib.car_arr_produce() %>
 	<%=htmlLib.error_arr_produce() %>
    <%=htmlLib.car_position_produce() %>
    <%=htmlLib.user_information_produce(session) %>
    <script>
        //產生user information
        /*
        let user_information = [];
        user_information = ['<img src="head/head01.png" alt="">', '有貝爾來']
        //------------------------
        // 產生TD2的使用者列表
       
        let user_arr = [];
        for (let i = 0; i < 2; i++) {
            user_arr[i] = ["a", "b", "c"];
        }
        let total = 2
        //-----------------    
        // 產生TD3的車車資訊列表
        let car_arr = [];
        for (let i = 0; i < 2; i++) {
            car_arr[i] = ["綠車", "一號位置", "2", "1", "3", "2"];
        }
        let car_arr_length = 2
        //-------------------------
        // 產生TD4的錯誤資訊列表
        let error_arr = [];
        for (let i = 0; i < 2; i++) {
            error_arr[i] = ["倉庫缺貨", "2022-07-12-09-30", "已排除"];
        }
        let error_arr_length = 2
        //-----------------------
        //產生車車位置資訊
        let car1_position = -1;
        let car2_position = -1;
        //------------------*/
    </script>

    <script>
        //產生user information
        $(".header_ul").append("<li>" + user_information[0] + "</li><li>" + user_information[1] + "</li>")
    </script>

    <script>
        // 產生TD2的使用者列表
        //user_arr  and total set at htmlLib.user_arr_produce()
        for (let i = 0; i < total; i++) {
            $(".td2 tbody").append("<tr><td>" + user_arr[i][0] + "</td><td>" + user_arr[i][1] + "</td><td>" + user_arr[i][2] + "</td></tr>");
        }
    </script>
    <script>
        // 產生TD3的車車資訊列表
        //car_arr  and car_arr_length set at htmlLib.car_arr_produce()
        for (let i = 0; i < car_arr_length; i++) {
            $(".td3 tbody").append("<tr><td>" + car_arr[i][0] + "</td><td>" + car_arr[i][1] + "</td><td>" + car_arr[i][2]
                + "</td><td>" + car_arr[i][3] + "</td><td>" + car_arr[i][4] + "</td><td>" + car_arr[i][5] + "</td></tr>");
        }
    </script>
    <script>
        //error_arr  and error_arr_length set at htmlLib.error_arr_produce()
        //產生TD4的錯誤資訊列表
        for (let i = 0; i < error_arr_length; i++) {
            $(".td4 tbody").append("<tr><td>" + error_arr[i][0] + "</td><td>" + error_arr[i][1] + "</td><td>" + error_arr[i][2]
                + "</td></tr>");
        }
    </script>
    <script>
        //產生車車位置資訊
        let c1p = ".car1p" + car1_position;
        let c2p = ".car2p" + car2_position;
        $(c1p).append('<img src="dicarimg/dicar_logo_green.png" style="max-width: 90%;" alt="">')
        $(c2p).append('<img src="dicarimg/dicar_logo.png" style="max-width: 90%;" alt="">')
        $(".button_g").click(function () {
            car1_position += 1;
            car1_position %= 3;
            showimg();
        })
        $(".button_r").click(function () {
            car2_position += 1;
            car2_position %= 3;
            showimg();
        })
        function showimg() {
        	//將車車位置資訊 顯示在地圖上
            c1p = ".car1p" + car1_position;
            c2p = ".car2p" + car2_position;
            $(".map_div td").empty();
            $(c1p).append('<img src="dicarimg/dicar_logo_green.png" style="max-width: 90%;" alt="">')
            $(c2p).append('<img src="dicarimg/dicar_logo.png" style="max-width: 90%;" alt="">')
        }
    </script>



    <script>
    //邊邊縮進去 跟跑出來的程式碼
        $(".sideButton").click(function () {
            $(".side").css("width", "22px")
            $(".side .out").css("display", "none")
            $(".in").css("display", "block")
        })
        $(".in li").click(function () {
            $(".side").css("width", "200px")
            $(".side .out").css("display", "block")
            $(".in").css("display", "none")
        })
    </script>
    <script>
        $(".title").css("left", "20%")
    </script>


    <script>
//讓標題的車車移動 的程式碼
        var i_dicar = 1;
        var i_str = "01";
        var dicar_change_img_y = function dicar1to22() {
            setTimeout(function () {
                let dicar_src = "dicarimg/dicar0" + i_str + ".png"
                $(".img_dicar").attr("src", dicar_src)
                i_dicar = i_dicar + 1
                if (i_dicar < 23) {
                    i_str = i_dicar;
                    if (i_dicar < 10) {
                        i_str = "0" + i_dicar;
                    }
                    dicar_change_img_y();
                }
            }, 300)
        }

        $(".img_dicar").click(dicar_change_img_y)
    </script>
    



</body>

</html>