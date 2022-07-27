function header_side_append() {
    $("body").prepend('<div class="side"><ul class="out">'
        + '<li><span class="sideButton"><img src="icon/menu.png" alt=""> </span>歡迎</li>'
        + '    <li><img src="icon/home.png" alt=""><a href="Home.html">'
        + '            <span>首頁</span>'
        + '        </a></li>'
        + '    <li><img src="icon/introduction.png" alt=""><a href="Introduction.jsp"><span>dicar介紹</span></a></li>'
        + '    <li><img src="icon/car.png" alt=""><a href="CarData.html"><span>貨櫃車系統</span></a></li>'
        + '    <li><img src="icon/storehouse.png" alt=""><a href="Storehouse.html"><span>倉儲系統</span></a></li>'
        + '    <li><img src="icon/error.png" alt=""><a href="ErrorList.html"><span>異常通報紀錄</span></a></li>'
        + '    <li><img src="icon/camera.png" alt=""><a href="Stream.html"><span>即時影線監控</span></a></li>'
        + '    <li><img src="icon/telephone.jpg" alt=""><a href="Contact.html#first-row"><span>聯絡我們</span></a></li>'
        + '    <li><a href=""><span></span></a></li>'
        + '    <li><a href=""><span></span></a></li>'
        + '  <li>_</li>'
        + '  <li><span class="language"> <img src="icon/language.png" alt=""> <select name="language" id="language">'
        + '              <option value="default">Language</option>'
        + '              <option value="Ch">中文</option>'
        + '              <option value="En">English</option>'
        + '          </select>'
        + '        </span></li>'
        + '    <li><img src="icon/logout.png" alt=""><a href="Login.html"> <span>登出</span></a></li>'
        + '</ul>'

        + '</div>'
        + '<ul class="in" style="display: none;">'
        + '<li style="background-color: black;"><img style="height: 20px;" src="icon/menu.png" alt=""></li>'
        + '</ul>'

        + '<div class="div_header">'
        + '<header>'
        + '    <span class="title"> <img class="img_dicar logo" src="dicarimg/dicar001.png"'
        + '            style="max-height: 95%; border-radius: 25px;" alt="">'
        + '    </span>'
        + '    <ul class="header_ul">'
        + '    </ul>'
        + '</header>'
        + '</div>')
}
header_side_append()
let user_information = [];
user_information = ['<img src="head/head01.png" alt="">', '有貝爾來']
function header_ul_append() {
    $(".header_ul").empty().append(
        "<li>" + user_information[0] + "</li><li>"
        + user_information[1] + "</li>")
}
header_ul_append();