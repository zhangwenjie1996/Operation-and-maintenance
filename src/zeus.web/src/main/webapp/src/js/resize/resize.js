//计算leftMenu/content高度
(function($){ 
    $(window).on("resize", auto);
    function auto() { 
    	 var winH = document.documentElement.clientHeight || document.body.clientHeight,
         winW = document.documentElement.offsetWidth || document.body.offsetWidth,
         navH = document.getElementsByClassName('navbar')[0].scrollHeight;
     var topH = document.getElementById('top').offsetHeight, leftMenuW = document.getElementById('leftMenu').offsetWidth;
     var curH = winH - navH - topH;
     var curW = winW - leftMenuW;
        $("body").css("height", winH); 
//        $("#content").css({"height": curH, "width": curW});
        $("#content").css({"width": curW,"height": curH}); 
//        $("iframe").css("height", curH);
        $("#leftMenu").css("height", curH);
        $("#leftMenu").mCustomScrollbar({
        	  mouseWheelPixels:300,
        	setHeight:curH,
            theme:"dark-thick",
            scrollInertia:400,
            scrollAmount:400
		});
  
//        $("iframe").addClass("mCustomScrollbar");
//        $("iframe").attr("data-mcs-theme","dark"); 
        $(".navbar-toggle").on("click", function () {
            if (!$(".collapse").hasClass("in")) {
                $("#leftMenu").css("height", curH );
                $("#leftMenu").mCustomScrollbar({
        			setHeight:curH ,
        			theme:"minimal-dark"
        		});
            } else {
                $("#leftMenu").css("height", curH);
                $("#leftMenu").mCustomScrollbar({
        			setHeight:curH,
        			theme:"minimal-dark"
        		});
            }

        })
    }
    auto();
 
})(jQuery);
 