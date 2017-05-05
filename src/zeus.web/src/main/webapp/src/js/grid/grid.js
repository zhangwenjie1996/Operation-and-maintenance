
var gridFn = function (url, id, rowID,addCallBack,delCallBack,updateCallBack ,viewCallBack  ) {
    var $grid = $("#" + id); 
    addCallBack();
//    $(".addBtn" + cId).on("click", function (e) {
// 
//    	
////        $(".tabbar").html("����");
////        $("cd-popup" + cId).addClass('is-visible');
////        $().cdPopUp("cd-popup" + cId);
////        $().dia("cd-popup" + cId, e);
////        $(".storageInInvoiceID").text("1");
////        curd.cdBtnSave(addURL, ".cd-popup" + cId + " " + "#formDevice",id);
//    });
    $grid.bootgrid("destroy");
    var idname = rowID;
   var specialParam="materialRelationID";
    var parameterID="parameterID";
    var formatters = {
        "commands": function (column, row) {
            return "<a abs=\"�鿴\" class=\"btn-color btn btn-xs btn-default command-view\" a=\"" + row[parameterID] + "\" data-row-id=\"" + row[idname] + "\"><span class=\"fa  fa-eye\"></span></a>"
                + "<a  abs=\"�༭\" class=\"btn-color btn btn-xs btn-default command-edit\"  a=\"" + row[parameterID] + "\"  data-row-id=\"" + row[idname] + "\"><span class=\"glyphicon glyphicon-pencil\"></span></a> " +
                "<a  abs=\"ɾ��\" class=\"btn-color btn btn-xs btn-default command-delete\"  a=\"" + row[parameterID] + "\" p=\"" + row[specialParam] + "\" data-row-id=\"" + row[idname] + "\"><span class=\"glyphicon glyphicon-trash\"></span></a>";
        }
    };
    var grid = pack.gridInit(url, id, formatters).on("loaded.rs.jquery.bootgrid",
        function () {
       
       
            /* Executes after data is loaded and rendered */
            $().tip();
         $("#grid-data2 tr").each(function (index, item) {
                var text = $($(item).find("td")[6]);
                console.log(text.text());
                if (text.text() == 0) {
                    text.text("常规");
                }
                if (text.text() == 1) {
                    text.text("重要");
                }
                if (text.text() == 2) {
                    text.text("关键");
                }
                if (text.text() == 3) {
                    text.text("特殊");
                }
		    })
		    
             grid.find(" a.command-delete").on("click", function () {
delCallBack(this);
//                curd.delBtn(delURL, this)

            }).end().find("a.command-edit").on("click", function (e) {
//                $("cd-popup" + cId).addClass('is-visible');
//                $().cdPopUp("cd-popup" + cId);
//                $().dia("cd-popup" + cId, e);
//                $(".tabbar").html("�༭");
//                curd.showInfo(detailURL,this);
            	updateCallBack(this);
            
//                curd.cdBtnSave(saveURL, ".cd-popup" + cId + " " + "#formDevice",id);
            }).end().find("a.command-view").on("click",
                function (e) {
//                   
//                    $("cd-popup" + cId).addClass('is-visible');
//                    $().cdPopUp("cd-popup" + cId);
//                    $().dia2("cd-popup" + cId, e);
//                    $(".tabbar").html("�鿴");
//                    curd.showInfo(detailURL,this);
            	viewCallBack(this);
                })
        });

};


