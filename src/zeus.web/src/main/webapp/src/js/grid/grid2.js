
var flag,materialModelCode;
var planningFilter = function (url, id, rowID) {
 
    var $grid = $("#" + id) ;
    var gridID = "#" + id;
    var reg=/\d/;
    var cId=reg.exec(gridID);
    $(".addBtn"+ cId).on("click", function (e) {

        $(".tabbar").html("����");
        $("cd-popup"+cId).addClass('is-visible');
        $().cdPopUp("cd-popup"+cId);
        $().dia("cd-popup"+cId,e);
        $(".storageInInvoiceID").text("1");
        curd.cdBtnSave("postController/add", ".cd-popup"+cId+" "+"#formDevice");
    });
    $grid.bootgrid("destroy");
    var idname = rowID;
    var formatters = {
        "commands": function (column, row) {
            return "<a abs=\"�鿴\" class=\"btn-color btn btn-xs btn-default command-view\"  data-row-id=\"" + row[idname] + "\"><span class=\"fa  fa-eye\"></span></a>"
                + "<a  abs=\"�༭\" class=\"btn-color btn btn-xs btn-default command-edit\"  data-row-id=\"" + row[idname] + "\"><span class=\"glyphicon glyphicon-pencil\"></span></a> " +
                "<a  abs=\"ɾ��\" class=\"btn-color btn btn-xs btn-default command-delete\"  data-row-id=\"" + row[idname] + "\"><span class=\"glyphicon glyphicon-trash\"></span></a>";
        }
    };
   var grid= pack.gridInit(url, id, formatters).on("loaded.rs.jquery.bootgrid",
        function () {
            /* Executes after data is loaded and rendered */
            $().tip();
            console.log(gridID + " .command-delete");
            grid.find( " a.command-delete").on("click", function () {
                alert("delete");
                curd.delBtn("postController/delete")
            }).end().find("a.command-edit").on("click", function (e) {
                $("cd-popup"+cId).addClass('is-visible');
                $().cdPopUp("cd-popup"+cId);
                $().dia("cd-popup"+cId,e);
                $(".tabbar").html("�༭");
                curd.showInfo('postQueryController/findById');
                curd.cdBtnSave("postController/edit", ".cd-popup"+cId+" "+"#formDevice");
            }).end().find("a.command-view").on("click",
                function (e) {
                    alert("aaa");
                    $("cd-popup"+cId).addClass('is-visible');
                    $().cdPopUp("cd-popup"+cId);
                    $().dia2("cd-popup"+cId,e);
                    $(".tabbar").html("�鿴");
                    curd.showInfo('postQueryController/findById');
                })
        });

};


