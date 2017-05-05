$(window).on("resize", resize);
function resize() {
    $(".unit-tree").width($("#unit").width());
}
resize();
$(".drop-down-unit").on("click", function () {
    $(".unit-tree").toggle();
});
 
$(".filter-criteria button").on("click",function(){ 
	planningFilter2("../../DeviceInfo/findPage?&" + $("#filter-criteria").serialize(), "grid");
});
$.get('../../DeviceRelate/findAllMaterialCategory', "", function (data) {
	
	//console.log(data.data.length);
	$("#p_categoryID").append("<option value=''>-请选择-</option>");
	
	for(var i=0; i<data.data.length; i++){
		
	    //console.log(data.data[i].categoryName);
	    
		$("#p_categoryID").append("<option value='" + data.data[i].categoryID + "'>" + data.data[i].categoryName + "</option>");
		
	}
}, 'json')
var patrolRouteID;
$(".addBtn").off("click");
	$(".addBtn").on("click", function (e) {
   if (!patrolRouteID) {
        	swal({text: "请先选择路线!"});  
            return;
        }
        $().dia(e);
        $(".tabbar").html("增加");
        curd.ajax("../../PatrolRoute/findListByRouteId", "get",{patrolRouteID: patrolRouteID}, function (data) {
            var data = JSON.parse(data).data;
            var ary = [];
            $.each(data, function (index, item) {
                ary.push(item.itemID);
            });
            $.each(ary, function (index, item1) {
            	 $.each($("tr"), function (index, item2) {
                	if (parseInt($(item2).find("td").eq(1).text()) == item1) {
                    	$(item2).find("input").attr({ "checked": "checked","disabled":"disabled"});
                    }
                })
            })
            ary = [];
        }, function (data) {
        	swal({text: data.message});
        })
        $("#grid").find("input[name='select']").removeAttr("disabled");   
    });
	  function demo_create() {
		  $("#form1")[0].reset();
	        $('#myModal').modal().find("input").removeAttr("readonly", "readonly");
	        $("#myModalLabel").html("添加小组");
	        $(".modal-footer").show();
	        $save.off("click");
	        $save.on("click", function () {
	        	 var arr = $("#form1").serialize();
	        	  curd.treeSave("../../PatrolRoute/addRoute","get","#","ajax" ,arr,"patrolRouteName",function(){
	              	loadPatrolGroup("../../PatrolRoute/findRouteTree");
	              }) ;
	        });
	    }
	  loadPatrolGroup("../../PatrolRoute/findRouteTree");
	  loadPatrolGroup("../../organ/getOrganListTree");
	  //所属 下拉树 
	  function loadPatrolGroup(url) {
	      $.ajax({
	          url: url,
	          type: "get",
	          success: function (data) {
	              var dataJson = JSON.parse(data);
	              if(url=="../../PatrolRoute/findRouteTree"){
	              	callBack(dataJson.data, "ajax");	
	              }else if(url=="../../organ/getOrganListTree"){
	              	  callBack2(dataJson.data, "organSelect");	
	              }
	              
	            
	          }
	      });
	  }
	  function callBack2(data, treeid) {
//	  	 $('#' + treeid).data('jstree', false).empty();
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
	 
//    //所属单位下拉树
//    function loadPatrolRoute(url) {
//        $.ajax({
//            url: "../../PatrolRoute/findRouteTree",
//            type: "get",
//            success: function (data) {
//            	var dataJson = JSON.parse(data);
//                callBack(dataJson.data, "ajax");
//            }
//        });
//    }
    var $save = $("#save");
    function callBack(data, treeid) {
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
                              	 var param={patrolGroupID: clickedNode.id};
                            	curd.treeDel("../../PatrolRoute/deleteRoute","get",treeid,param);                              
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
curd.treeInfo("../../PatrolRoute/findRouteById", "get",{patrolRouteID: clickedNode.id.replace(reg, "$1")}) ;
$save.off("click");
$save.on("click", function () {
	 var arr = $("#form1").serialize();
	  curd.treeUpdate("../../PatrolRoute/updateRoute","get",treeid ,arr,"patrolRouteName" );
});
                            }

                        }
                    }
                }).bind("activate_node.jstree", function (e, data) {
            // 处理代码
            // 获取当前节点
            var currentNode = data.node;
            clickID = currentNode.id;
            patrolRouteID = clickID;
        sessionStorage.setItem("id",clickID);
planningFilter("../../PatrolRoute/findByRouteId?patrolRouteID=" + clickID, "grid-data");
        }).bind("loaded.jstree", function (e, data) {
            tree.jstree().clear_state();
        });
    }

    var planningFilter = function (url, container) {
        var grid = $("#" + container);
        grid.bootgrid("destroy");
        var idname = "patrolRouteDeviceID";
        var formatters = {
            "commands": function (column, row) {
                return "<a  abs=\"删除\" class=\"btn-color btn btn-xs btn-default command-delete\"  data-row-id=\"" + row[idname] + "\"><span class=\"glyphicon glyphicon-trash\"></span></a>";
            }
        };
        var grid = pack.gridInit(url, container, formatters).on("loaded.rs.jquery.bootgrid", function () {

            $().tip();
            /* Executes after data is loaded and rendered */
            grid.find(".command-delete").on("click", function (e) {
                curd.delBtn("../../PatrolRoute/deleteRouteDevice", this)
            })
        });
    };

  

    var rowIds = [], store = {};
    var planningFilter2 = function (url,container) {
    	 pack.gridInit(url,container).on("selected.rs.jquery.bootgrid", function (e, rows) {	
            $.each(rows, function (index, item) {
            	item.patrolRouteID= sessionStorage.getItem("id");
                rowIds.push(item);
            });
            console.log(JSON.stringify(rowIds));
        }).on("deselected.rs.jquery.bootgrid", function (e, rows) {
          $.each(rows, function (index, item) {
            	item.patrolGroupID= sessionStorage.getItem("id");
            	var index = $.inArray(item,rowIds);
            	console.log(index);
                rowIds.splice(index, 1);
            });
            console.log(rowIds);
        });
    };
    planningFilter2("../../DeviceInfo/findPage","grid");
 var $cdBtnSave= $(".cd-btn-save");
 $cdBtnSave.off("click");
 $cdBtnSave.on("click", function (e) {
    	  $("#grid").bootgrid("reload");
      //  console.log(rowIds);
       // store = {deviceOutInfoCommands: rowIds};  
        $.param(store, true);
       // var data = JSON.stringify(store); 
        var rIds=[];
        $.each(rowIds,function(index,item){
        	var item2={};
        	item2.orderCode=item.itemCode;
        	item2.patrolRouteDeviceName=item.modelName;
        	item2.patrolRouteID=item.patrolRouteID;
        	item2.itemID=item.itemID;
        	item2.deviceAddress=item.deviceAddress;
        	item2.sequence=1;
        	item2.state=item.deviceState;
        	item2.modelID=item.modelID;
        	rIds.push(item2);
        });
        $.ajax({
            type: "post",
            method: "post",
            contentType : 'application/json;charset=utf-8',
            url: "../../PatrolRoute/addRouteDevice",
            dataType: "json",
           // data: {"data": data},
            data: JSON.stringify(rIds),
            success: function (result) {
            	  $("#grid-data").bootgrid("reload");
        }
        });
        rowIds=[]
    })
   
   
