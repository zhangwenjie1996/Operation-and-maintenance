jQuery(document).ready(function($){
    //open popup
    //$('.command-edit').on('click', function(event){
    //    event.preventDefault();
    //    $('.cd-popup').addClass('is-visible');
    //});
    //close popup
    function cdPopUp(name){
        $('.'+name).on('click', function(event){
            if( $(event.target).is('.'+name+' '+'.cd-popup-close')  ) {
                event.preventDefault();
                $(this).removeClass('is-visible');
            }
        });
        //close popup when clicking the esc keyboard button
        $(document).keyup(function(event){
            if(event.which=='27'){
                $('.'+name).removeClass('is-visible');
            }
        });
    }
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
    function dia( name) {
    	cdPopUp(name);
        //e.preventDefault();
        $('.'+name).addClass('is-visible');
        $('.'+name+".cd-buttons").css("display","block");
        $('.'+name+" input").removeAttr("readonly","readonly");
    }
    function dia2(name) {
    	cdPopUp(name);
        //e.preventDefault();
        $('.'+name).addClass('is-visible');
        $('.'+name+".cd-buttons").css("display","none");
        $('.'+name+" input").attr("readonly","readonly");
    }
    jQuery.fn.extend({
        tip: tip,
        dia:dia,
        dia2:dia2,
        cdPopUp:cdPopUp
    });
});