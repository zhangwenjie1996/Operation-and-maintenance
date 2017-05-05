  $(".addBtn").on("click", function (e) {
            $().dia(e);
            $(".tabbar").html("增加");
        });
var planningFilter = function (url) {
    	alert("halo");
      
        var idname = "patrolRouteDeviceID";
        var formatters = {
            "commands": function (column, row) {
                return "<a  abs=\"删除\" class=\"btn-color btn btn-xs btn-default command-delete\"  data-row-id=\"" + row[idname] + "\"><span class=\"glyphicon glyphicon-trash\"></span></a>";
            }
        };
        var grid = pack.gridInit(url, "grid-data", formatters).on("loaded.rs.jquery.bootgrid", function () {

            $().tip();
            /* Executes after data is loaded and rendered */
            grid.find(".command-delete").on("click", function (e) {
                curd.delBtn("../../PatrolRouteController/deleteRouteDevice", this)
            })
        });
    };
  
function ajaxFn(ajaxURL, method, parm, callback) {
    $.ajax({
        url: ajaxURL + "?_=" + Math.random(),
        type: method,
        data: parm,
        dataType: "json",
        async: false,
        success: function (data) {
            //data = "JSON" in window ? JSON.parse(data) : eval("(" + data + ")");
            callback(data);
        }
    });
}
var jsonData, length;
function bindData(container) {
    var str = '';
    $.each(jsonData, function (index, item) {
        //str += '<li id="'+item["title"]+'">'+item["time"]+'</li>';
        str += '<li  data-id="' + item["patrolRouteID"] + '"><a  data-id="' + item["patrolRouteID"] + '"><i class="fa fa-star-half-empty"></i>' + item["patrolRouteName"] + '</a> </li>';
    });
    $("#" + container).html(str);
}
function a(){
	ajaxFn("../../PatrolRouteController/findAllRoute", "get", null, function (data) {
	    jsonData = data.data;
	    console.log(jsonData);
	    length = jsonData.length;
	    if (data.state == "Success") {
	        bindData("patrolRoute");
	    }
	});	
}
a();
var id, param, topVal, $container = $('#patrolRoute'), $li = $('#patrolRoute li'), $rightClick = $(".rightClick"), $del = $(".rightClick .del"), $edit = $(".rightClick .edit"), $addPatrol = $(".addPatrol"),$btnSave=  $("#save");

$container.bind("contextmenu", function (e) {
    return false;
});
$li.off("click");
$li.on("click", function (e) {
    id = $(e.target).data("id");
    $rightClick.hide();
    
    planningFilter("../../PatrolRouteController/findByRouteId?patrolRouteID=" + id);
});
$li.mousedown(function (e) {
    if (3 == e.which) {
        e && e.preventDefault ? e.preventDefault() : e.returnValue = false;
        topVal = $(e.target).offset().top + $(this).height();
        $rightClick.show();
        $rightClick.css({top: topVal});
        $del.off("click");
        $del.on("click", function () {
            $(e.target).remove();

            id = $(e.target).data("id");
            ajaxFn("../../PatrolRouteController/deleteRoute", "get", {patrolGroupID: id}, function (data) {
                if (data.state == "Success") {
                    alert("del success")
                    a();
                }
            });
        });
        $edit.off("click");
        $edit.on("click", function () {
            $('#myModal').modal().find("input").removeAttr("readonly", "readonly");
            $("#myModalLabel").html("编辑");
            $(".modal-footer").show();
            id = $(e.target).data("id");
            console.log(id);
            ajaxFn("../../PatrolRouteController/findRouteById", "get", {patrolGroupID: id}, function (data) {
                if (data.state == "Success") {
                    alert("edit success");
                    for (var key in data.data) {
                        $("#" + key).val(data.data[key])
                    }
                }
            });
          $btnSave.off("click");
          $btnSave.on("click", function () {
                alert("aa");
                param = {             
                    	patrolRouteID:$("#patrolRouteID").val(),
                        patrolRouteName: $("#patrolRouteName").val(),
                        description:$("#description").val(),
                        availability:$("#availability").val()
                    };
                ajaxFn("../../PatrolRouteController/updateRoute", "get", param, function (data) {
                    jsonData = data.data;
                    if (data.state == "Success") {
                        $(e.target).val("111")
                        a();
                    }
                });
            });
        });
    }
});


$addPatrol.off("click");
$addPatrol.on("click", function () {
//	param = {
//            patrolGroupName: $("#patrolGroupName").val(),
//            description:$("#description").val(),
//            availability:$("#availability").val()
//        };
    $('#myModal').modal().find("input").removeAttr("readonly", "readonly");
    $("#myModalLabel").html("添加路线");
    $(".modal-footer").show();
    $("#save").off("click");
    var arr1=$("#form1").serialize();
    $("#save").on("click",function(){
    	 param = {
                 patrolRouteName: $("#patrolRouteName").val(),
                 description:$("#description").val(),
                 availability:$("#availability").val()
             };
        ajaxFn("../../PatrolRouteController/addRoute", "get", param, function (data) {
            if (data.state == "Success") {
                alert("add success");
                
                a();
            }
       }); 	
    })

});

var flag, $save = $(".cd-btn-save ");
var planningFilter2 = function (url) {

    pack.gridInit(url, "grid").on("loaded.rs.jquery.bootgrid",
            function (e, rows ) {
                var values, obj, value;
                $save.off("click");
                $save.on("click", function (e) {
                    $("#grid").bootgrid("reload");
                    var ary = [];
                    $.each($("table#grid  tbody tr input:checked"), function (index, item) {
                        console.log(item);
                        var o = {},a={};
                        $.each($(item).parents("td").siblings("td"), function (index, item) {
                            var key = $("table#grid  thead tr th").eq(index + 1).data("column-id");
                            o[key] = $(item).text();
                            a.employeeID=o.employeeID;
                            a.employeeName=o.employeeName;
                        });
                        ary.push(a);
                    });
                    console.log(ary);

                    obj = {p: ary};
                    value = $.param(obj, true);                                                                                                                                                                                                                                                                                                                                                               
                    $.ajax({
                        type: "get",
                        method: "post",
                        url: "../../DeviceInOutController/storageOut",
                        dataType: "json",
                        data: value,
                        success: function (result) {
                            $("#grid").bootgrid("reload");
                            //window.location.href = "outboundOrder.html";
                            console.log("checked" + value);
                        }
                    });
                });
            })

};

planningFilter2("../../DeviceInfoController/findPage");

