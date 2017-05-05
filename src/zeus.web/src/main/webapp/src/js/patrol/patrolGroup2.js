$(window).on("resize", resize);
function resize() {
    $(".unit-tree").width($("#unit").width());
}
resize();
$(".drop-down-unit").on("click", function () {
    $(".unit-tree").toggle();
});
$(".searchGroup").on("click",function(){ 
	planningFilter2("../../user/findAll?"+$("#searchGroup").serialize(), "grid");
});
var patrolGroupID;
$(".addBtn").off("click");
$(".addBtn").on("click", function (e) {
    if (!patrolGroupID) { 
        swal({text:"请先选择小组!"});
        return;
    }
    $().dia(e);
    $(".tabbar").html("增加");
    curd.ajax("../../PatrolGroup/findListByGroupId", "get", {patrolGroupID: patrolGroupID}, function (data) {
        var data = JSON.parse(data).data;
        var ary = [];
        $.each(data, function (index, item) {
            ary.push(item.employeeId)
        });
        $.each(ary, function (index, item1) {
        	 $.each($("tr"), function (index, item2) {
            	if (parseInt($(item2).find("td").eq(1).text()) == item1) { 
                	$(item2).find("input").attr({  "checked": "checked", "disabled": "disabled" });
               }

            })
          
        })
     
        ary = [];
    }, function (data) {
        swal({text:data.message});
    });
    $("#grid").find("input[name='select']").removeAttr("disabled");  
});
function demo_create() {
    $("#form-group")[0].reset();
    $('#myModal').modal().find("input").removeAttr("readonly", "readonly");
    $("#myModalLabel").html("添加小组");
    $(".modal-footer").show();
    $save.off("click");
    $save.on("click", function () {
        var arr = $("#form-group").serialize();
        curd.treeSave("../../PatrolGroup/addGroup", "get", "#", "ajax", arr, "patrolGroupName",function(){
        	loadPatrolGroup("../../PatrolGroup/findAllGroup");
        });
       
    });
}
loadPatrolGroup("../../PatrolGroup/findAllGroup");
loadPatrolGroup("../../organ/getOrganListTree");
//所属 下拉树"../../PatrolGroup/findAllGroup"
function loadPatrolGroup(url) {
    $.ajax({
        url: url,
        type: "get",
        success: function (data) {
            var dataJson = JSON.parse(data);
            if(url=="../../PatrolGroup/findAllGroup"){
            	callBack(dataJson.data, "ajax");	
            }else if(url=="../../organ/getOrganListTree"){
            	  callBack2(dataJson.data, "organSelect");	
            }
            
          
        }
    });
}
function callBack2(data, treeid) {
//	 $('#' + treeid).data('jstree', false).empty();
var tree = $("#" + treeid);
var inst, clickedNode;
var reg = /^j1_(\d+)/;
tree.jstree(false);
pack.showCheckboxTree(
   data,
   treeid,
   "blue  fa fa-sitemap",
   "search-tree",
   ["dnd", "search", "state", "types", "wholerow"
   ], false,
   false,
   null).bind("activate_node.jstree", function (e, data) {
       // 处理代码
       // 获取当前节点
       var currentNode = data.node;
       clickID = currentNode.id;
       console.log(currentNode);
       $(".drop-down-unit").val(currentNode.text);
       $('#organSelect').hide();
       $("#serachorganid").val(clickID);
   }).bind("loaded.jstree", function (e, data) {
       tree.jstree().clear_state();
   });
}

var $save = $("#save");
function callBack(data, treeid) {
//    	 $('#' + treeid).data('jstree', false).empty();
    var tree = $("#" + treeid);
    var inst, clickedNode;
    var reg = /^j1_(\d+)/;
    tree.jstree(false);
    pack.showCheckboxTree(
        data,
        treeid,
        "blue  fa fa-sitemap",
        "search-tree",
        ["dnd", "search", "state", "types", "wholerow"
        ], false,
        false,
        {
            "items": {

                "remove": {
                    "label": "删除",
                    "icon": "fa fa-times",
                    "action": function (obj) {
                        inst = $.jstree.reference(obj.reference);
                        clickedNode = inst.get_node(obj.reference);
                        var param = {patrolGroupID: clickedNode.id};
                        curd.treeDel("../../PatrolGroup/deleteGroup", "get", treeid, param);
                    }
                },
                "rename": {
                    "label": "编辑",
                    "icon": "fa fa-pencil",
                    "_disabled": false,
                    "action": function (obj) {
                        inst = $.jstree.reference(obj.reference);
                        clickedNode = inst.get_node(obj.reference);
                        $('#myModal').modal().find("input").removeAttr("readonly", "readonly");
                        $("#myModalLabel").html("编辑");
                        $(".modal-footer").show();
                        curd.treeInfo("../../PatrolGroup/findGroupById", "get", {patrolGroupID: clickedNode.id.replace(reg, "$1")});
                        $save.off("click");
                        $save.on("click", function () {
                            var arr = $("#form-group").serialize();
                            curd.treeUpdate("../../PatrolGroup/updateGroup", "get", treeid, arr, "patrolGroupName");
                        });
                    }

                }
            }
        }).bind("activate_node.jstree", function (e, data) {
            // 处理代码
            // 获取当前节点
            var currentNode = data.node;
            clickID = currentNode.id;
            patrolGroupID = clickID;
            sessionStorage.setItem("id", clickID);
            planningFilter("../../PatrolGroup/findByGroupId?patrolGroupID=" + clickID, "grid-data");
        }).bind("loaded.jstree", function (e, data) {
            tree.jstree().clear_state();
        });
}

var planningFilter = function (url, container) {
    var $grid = $("#" + container);
    $grid.bootgrid("destroy");
    var idname = "patrolGroupMemberID";
    var formatters = {
        "commands": function (column, row) {
            return "<a  abs=\"删除\" class=\"btn-color btn btn-xs btn-default command-delete\"  data-row-id=\"" + row[idname] + "\"><span class=\"glyphicon glyphicon-trash\"></span></a>";
        }
    };
    var grid = pack.gridInit(url, container, formatters).on("loaded.rs.jquery.bootgrid", function () {

        $().tip();
        /* Executes after data is loaded and rendered */
        grid.find(".command-delete").on("click", function (e) {
            curd.delBtn("../../PatrolGroup/deleteGroupMember", this)
        })
    });
};


var rowIds = [], store = {};
var planningFilter2 = function (url, container) {
    var grid2 = pack.gridInit(url, container).on("selected.rs.jquery.bootgrid", function (e, rows) {
        $.each(rows, function (index, item) {
            item.patrolGroupID = sessionStorage.getItem("id");
            rowIds.push(item);
        });
        console.log(JSON.stringify(rowIds));
    }).on("deselected.rs.jquery.bootgrid", function (e, rows) {
        $.each(rows, function (index, item) {
            item.patrolGroupID = sessionStorage.getItem("id");
            var index = $.inArray(item, rowIds);
            console.log(index);
            rowIds.splice(index, 1);
        });
        console.log(rowIds);
    });
};
planningFilter2("../../user/findAll", "grid");
var $cdBtnSave = $(".cd-btn-save");
$cdBtnSave.off("click");
$cdBtnSave.on("click", function (e) {
//    	  $("#grid").bootgrid("reload");
    console.log(rowIds);
    // store = {employeeCommands: rowIds};
    $.param(store, true);
    // var data = JSON.stringify(store); \
    var rIds = [];
    $.each(rowIds, function (index, item) {
        var item2 = {};
        item2.employeeId = item.employeeid;
        item2.employeeName = item.employeename;
        item2.patrolGroupID = item.patrolGroupID;
        rIds.push(item2);
    });
    $.ajax({
        type: "post",
        method: "post",
        contentType: 'application/json;charset=utf-8',
        url: "../../PatrolGroup/addGroupMember",
        dataType: "json",
        // data: {"data": data},
        data: JSON.stringify(rIds),
        success: function (result) {
            $("#grid-data").bootgrid("reload");
            //回显
//            	planningFilter("../../PatrolGroup/findByGroupId?patrolGroupID=" + clickID, "grid-data");
        }
    });
    //回显
//    	planningFilter("../../PatrolGroup/addGroupMember?data="+JSON.stringify(rIds), "grid-data");
    rowIds = []
})
   
