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

var jsonData, $save = $("#save"),length;
function bindData(container) {
    var str = '';
    $.each(jsonData, function (index, item) {
        //str += '<li id="'+item["title"]+'">'+item["time"]+'</li>';
        str += '<li><a >' + item["patrolGroupName"] + '</a><span data-id="' + item["patrolGroupID"] + '" class="spanEdit">编辑 </span><span  data-id="' + item["patrolGroupID"] + '" class="spanDel">删除 </span></li>';
    });
    $("#" + container).html(str);
}
ajaxFn("../../src/json/patrolGroup.json", "get", null, function (data) {
    jsonData = data.data;
    length=jsonData.length;
    if (data.state == "Success") {
        bindData("patrolGroup");
    }
});
var parentLiID, siblingA, param;
$(".spanEdit").off("click");
$(".spanEdit").on("click", function () {
    siblingA = $(this).siblings("a");
    parentLiID = $(this).data("id");
    $('#myModal').modal().find("input").removeAttr("readonly", "readonly");
    $("#myModalLabel").html("编辑");
    $(".modal-footer").show();
    ajaxFn("../../src/json/patrolGroup.json", "get", {patrolGroupID: parentLiID}, function (data) {
        if (data.state == "Success") {
            for (var key in data.data) {
                $("#" + key).val(data.data[key])
            }
        }
    });
    $save.off("click");
    $save.on("click", function () {
        param = {
            patrolGroupID: $("#patrolGroupID").val(),
            patrolGroupName: $("#patrolGroupName").val()
        };
        ajaxFn("../../src/json/patrolGroup.json", "get", param, function (data) {
            jsonData = data.data;
            if (data.state == "Success") {
                siblingA.val("111")
            }
        });
    });

});
$(".spanDel").off("click");
$(".spanDel").on("click", function () {
    $(this).parent("li").remove();
    parentLiID = $(this).data("id");
    ajaxFn("../../src/json/patrolGroup.json", "get", {patrolGroupID: parentLiID}, function (data) {
        if (data.state == "Success") {
            alert("del success")
        }
    });


});
$(".addGroup").off("click");
$(".addGroup").on("click", function () {
    $('#myModal').modal().find("input").removeAttr("readonly", "readonly");
    $("#myModalLabel").html("增加");
    $(".modal-footer").show();
    ajaxFn("../../src/json/patrolGroup.json", "get", {patrolGroupID: length}, function (data) {
        if (data.state == "Success") {
            alert("add success");
            $("#patrolGroup").refresh();
        }
    });
});



