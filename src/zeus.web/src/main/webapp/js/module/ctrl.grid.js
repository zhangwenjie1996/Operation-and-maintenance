define(['jquery', 'bootgrid'], function ($, boot) {
    var name;
    var url;
    var ajax = true;
    var selection = false;
    var multiSelect = false;

    //回调方法
    var onSelected;
    var onDeselected;

    //构造
    function ctor(gridName, dataUrl) {
        name = gridName;
        url = dataUrl;

    }

    //允许选择并，传递一个回调方法和是否允许复选。回调方法参数维选择行数组。
    function setSelection(isMulti, selCallback, deselCallback) {
        selection = true;
        multiSelect = isMulti === true ? isMulti : false;
        onSelected = selCallback;
        onDeselected = deselCallback;
    }

    //初始化grid
    function init() {
        var grid = $(name).bootgrid({
            ajax: ajax,
            ajaxSettings: {
                method: "GET",
                cache: false
            },
            selection: selection,
            multiSelect: multiSelect,
            url: url,
            formatters: {
                "link": function (column, row) {
                    return "<a href=\"#\">" + column.id + ": " + row.id + "</a>";
                }
            }
        });

        //如果允许选择，则注册选择事件
        if (selection) {
            grid = grid.on("selected.rs.jquery.bootgrid", function (e, rows) {
                if ($.isFunction(onSelected))
                    onSelected(rows);
            }).on("deselected.rs.jquery.bootgrid", function (e, rows) {
                if ($.isFunction(onDeselected))
                    onDeselected(rows);
            });
        }
    }

    //获取选择的行数据，回调方法参数维选择行id数组。
    function getSelectedRows(callback) {
        var rows = $(name).bootgrid("getSelectedRows");
        if ($.isFunction(callback)) {
            callback(rows);
        }
        else {
            console.log(rows);
        }
    }

    return {
        "setSelection": setSelection,
        "ctor": ctor,
        "init": init,
        "getSelectedRows": getSelectedRows
    };
});