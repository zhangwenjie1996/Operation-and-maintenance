var pack = (function () {
    function showCheckboxTree(url, id, icon, inp, plugins, multiple, tie_selection, contextmenu) {
        $.ajaxSetup({cache: false});
        treeid = id;
        var to = false;
        if (inp) {
            $("#" + inp).keyup(function () {
                if (to) {
                    clearTimeout(to);
                }
                to = setTimeout(function () {
                    var v = $("#" + inp).val();
                    $("#" + id).jstree(true).search(v);
                }, 250);
            });
        }
      
        var obj = {
            "core": {
                "multiple": multiple,
                "animation": 0,
                "check_callback": true,//右击菜单必须
                "themes": {"stripes": false, "dots": true},
                "data": {
                    "url": url,
                    "datatype": "json",
                    "data": function (node) {

                        return {"id": node.id};
                    }
                }
            },
            "types": {
                "default": {
                    "icon": icon
                },
                "demo": {
                    "icon": "jstree-file"
                },
                "valid_children": [-1]
            },
            "checkbox": {
                "keep_selected_style": false,
                "whole_node": true,
                "visible": true,//是否显示checkbox
                "three_state": true,//是否联级
                "tie_selection": tie_selection

            },
            "plugins": plugins
        };
        // var reg=/^j1_(\d+)(_anchor)?$/,str=$("li").attr("id");
        // console.log($("#ajax li"),str)
        // if(reg.test(str)){
        //     alert("pp");
        //     str.replace(reg,"$1")
        // }
        if (contextmenu) {
            obj.plugins.push("contextmenu");
            obj.contextmenu = contextmenu
        }
        return menuTree = $("#" + id).jstree(
            obj
        )
    }

    function gridInit(url, id, formatters) {
   return   $("#" + id).bootgrid({
            ajax: true,
            ajaxSettings: {
                method: "post",
                cache: false

            },

            data: {name: "zwj"},
            url: url,
            pagination: 1,
            selection: true,
            multiSelect: true,

            formatters: formatters


        })
    }


    return {
        showCheckboxTree: showCheckboxTree,


        gridInit: gridInit
    }
})();

