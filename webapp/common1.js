/**此檔案放一些 全部網頁都會用到的SCRIPT
 * 
 */
        $(".sideButton").click(function () {
            $(".side").css("width", "20px")
            $(".side .out").css("display", "none")
            $(".in").css("display", "block")
        })
        $(".in li").click(function () {
            $(".side").css("width", "200px")
            $(".side .out").css("display", "block")
            $(".in").css("display", "none")
        })
        
        $(".title").css("left","30%")
        
       
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
   //--------------
   
    
   
    