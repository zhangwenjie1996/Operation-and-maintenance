//
//$(function () {
//	$(".fir-ul > li > a").click(function () {
//		$(this).addClass("xz").parents().siblings().find("a").removeClass("xz");
//		$(this).find('.arrow1').toggle();
//		$(this).find('.arrow2').toggle();
//		$(this).parents().siblings().find(".sec-ul ").hide(300);
//		$(this).siblings(".sec-ul").toggle(300);
//		$(this).parents().siblings().find(".sec-ul > li > .thr-ul").hide();
//	});
//
//	$(".sec-ul > li > a").click(function () {
//		$(this).addClass("sen_x").parents().siblings().find("a").removeClass("sen_x");
//		$(this).parents().siblings().find(".thr-ul").hide(300);
//		$(this).siblings(".thr-ul").toggle(300);
//	});
//
//	$(".thr-ul > li > a").click(function () {
//		$(this).addClass("xuan").parents().siblings().find("a").removeClass("xuan");
//
//	});
//
//});
function fn(){
	$("#leftMenu>ul > li > a").click(function () {
		  $(this).addClass("xz");
//		  $(this).children("i").eq(0).css("marginLeft","5px");
	});
	  $(".left-menu-ul > li > a").click(function () {
	        $(this).parents().siblings().find("a").removeClass("xz");
	        $(this).find('.arrow1').toggle();
	        $(this).find('.arrow2').toggle();
		 if( $(this).next().find("li").hasClass("one")){
			 $(this).next().toggle(300)
		 }

	    });

	    //$(".sec-ul > li > a").click(function () {
	    //    $(this).addClass("sen_x").parents().siblings().find("a").removeClass("sen_x");
	    //    $(this).parents().siblings().find(".thr-ul").hide(300);
	    //    $(this).siblings(".thr-ul").toggle(300);
	    //});
        //
	    //$(".thr-ul > li > a").click(function () {
	    //    $(this).addClass("xuan").parents().siblings().find("a").removeClass("xuan");
	    //})

}
fn();