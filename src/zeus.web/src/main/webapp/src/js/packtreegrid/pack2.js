var pack = (function () {
    function showCheckboxTree(jsonData, id, icon, inp, plugins, multiple, three_state, contextmenu) {
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
                "data": jsonData

            },
            "types": {
                "default": {
                    "icon": icon
                },
                "demo": {
                    "icon": "jstree-file"
                }
//                "valid_children": [-1]
            },
            "checkbox": {
                "keep_selected_style": false,
                "whole_node": true,
                "visible": true,//是否显示checkbox
                "three_state": three_state,//是否联级
                "tie_selection": true

            },
            "plugins": plugins
        };
//        $('#ajax').jstree('destroy');
     //   $.jstree.destroy ();

        $('#'+id).jstree('destroy');
//        $.jstree.destroy();
        if (contextmenu) {
            obj.plugins.push("contextmenu");
            obj.contextmenu = contextmenu
        }
        return menuTree = $("#" + id).jstree(
            obj
        )
    }

    function gridInit(url, id, formatters) {
    	$("#" + id).bootgrid("destroy");
        return $("#" + id).bootgrid({
            ajax: true,
            ajaxSettings: {
                method: "get",
                cache: false
            },
            url: url,
            pagination: 1,
            selection: true,
            multiSelect: true,
            keepSelection: true,
            formatters: formatters
            
        })
    }
    return {
        showCheckboxTree: showCheckboxTree,
        gridInit: gridInit
    }
})();

