~function (jQuery) {
    function right(container,ajaxURL) {
        var jsonData = null;
        $.ajax({
            url: ajaxURL + "?_=" + Math.random(),
            type: "get",
            dataType: "json",
            async: false,
            success: function (data) {
                jsonData = data;
            }
        });

        //2、实现数据的绑定
        bindData();
        function bindData() {
            var str = '';
            $.each(jsonData, function (index, item) {
                str += '<li id="'+item["roleID"]+'">'+item["roleName"]+'</li>';
            });
            $("#"+container).html(str);
        }
    }
    jQuery.fn.extend({
        right: right
    });
}(jQuery);
