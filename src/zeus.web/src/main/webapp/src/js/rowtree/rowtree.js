//define(["jquery"],function ($) {
//    function dosome() {
//        $(window).on("resize", auto);
//        function auto() {
//            var winH = document.documentElement.clientHeight || document.body.clientHeight, winW = document.documentElement.offsetWidth || document.body.offsetWidth;
//            $(".row-tree-menu").css("height", winH);
//            if (winW <= 768) {
//                $(".row-tree-menu").css("height", "100%");
//            }
//        }
//        auto();
//    }
//    return {
//        "dosome": dosome
//    };
//});
   $(window).on("resize", auto);
        function auto() {
            var winH = document.documentElement.clientHeight || document.body.clientHeight, winW = document.documentElement.offsetWidth || document.body.offsetWidth;
            $(".row-tree-menu").css("height", winH);
            if (winW <= 768) {
                $(".row-tree-menu").css("height", "100%");
            }
        }
        auto();