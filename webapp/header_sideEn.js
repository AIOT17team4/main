function header_side_append() {
    $("body").prepend('<div class="side"><ul class="out">'
        + '<li><span class="sideButton"><img src="icon/menu.png" alt=""> </span>Welcome~</li>'
        + '    <li><img src="icon/home.png" alt=""><a href="HomeEn.html">'
        + '            <span>Home</span>'
        + '        </a></li>'
        + '    <li><img src="icon/introduction.png" alt=""><a href="Introduction.jsp"><span>dicar introduction</span></a></li>'
        + '    <li><img src="icon/car.png" alt=""><a href="CarDataEn.html"><span>Car System</span></a></li>'
        + '    <li><img src="icon/storehouse.png" alt=""><a href="StorehouseEn.html"><span>Storehouse System</span></a></li>'
        + '    <li><img src="icon/error.png" alt=""><a href="ErrorListEn.html"><span>Error List</span></a></li>'
        + '    <li><img src="icon/camera.png" alt=""><a href="StreamEn.html"><span>Stream </span></a></li>'
        + '    <li><img src="icon/telephone.jpg" alt=""><a href="Contact.html#first-row"><span>contact us</span></a></li>'
        + '    <li><a href=""><span></span></a></li>'
        + '    <li><a href=""><span></span></a></li>'
        + '  <li>_</li>'
        + '  <li><span class="language"> <img src="icon/language.png" alt=""> <select name="language" id="language">'
        + '              <option value="default">Language</option>'
        + '              <option value="Ch">中文</option>'
        + '              <option value="En">English</option>'
        + '          </select>'
        + '        </span></li>'
        + '    <li><img src="icon/logout.png" alt=""><a href="Login.html"> <span>Logout</span></a></li>'
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