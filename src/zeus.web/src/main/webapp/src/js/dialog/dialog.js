jQuery(document).ready(function($){
    //open popup
    //$('.command-edit').on('click', function(event){
    //    event.preventDefault();
    //    $('.cd-popup').addClass('is-visible');
    //});
    //close popup
    $('.cd-popup').on('click', function(event){
//        if( $(event.target).is('.cd-popup-close') || $(event.target).is('.cd-popup') ) {
        	if( $(event.target).is('.cd-popup-close')  ) {
            event.preventDefault();
            $(this).removeClass('is-visible');
        }
    });


    //close popup when clicking the esc keyboard button
    $(document).keyup(function(event){
        if(event.which=='27'){
            $('.cd-popup').removeClass('is-visible');
        }
    });
    //small tip
    function tip(){
        var $htmlLi = $('<div class="tooltip top" role="tooltip">' +
            '<div class="tooltip-arrow"></div>' +
            '<div class="tooltip-inner">' +
            '</div>' +
            '</div>');
        $(".command-view,.command-edit,.command-delete").on("mouseover", function () {
            $(this).append($htmlLi);
            $htmlLi.find(".tooltip-inner").html($(this).attr("abs"));
        }).on("mouseout", function () {
            $htmlLi.remove();
        });
    }
    function dia(e) {
        //e.preventDefault();
        $('.cd-popup').addClass('is-visible');
        $(".cd-buttons").css("display","block");
        $(".cd-popup input").removeAttr("readonly","readonly");
        $(".cd-popup select").removeAttr("disabled","disabled");
    }
    function dia2(e) {
        //e.preventDefault();
        $('.cd-popup').addClass('is-visible');
        $(".cd-buttons").css("display","none");
        $(".cd-popup input").attr("readonly","readonly");
        $(".cd-popup select").attr("disabled","disabled");
    }
    jQuery.fn.extend({
        tip: tip,
        dia:dia,
        dia2:dia2
    });
});