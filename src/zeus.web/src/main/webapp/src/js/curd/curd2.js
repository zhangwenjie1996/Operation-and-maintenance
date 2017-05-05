var curd = (function () {
  function ajax(url,method,param,doneCallBack,failCallBack){  
	       $.ajax({
          type: method,
          method: method,
          url: url,
          data: param 

      }).done(function (data) {
    	  doneCallBack(data);
      }).fail(function (data) {
    	  failCallBack(data);
          })  
  }
    //->cdBtnSave:表单保存
    function cdBtnSave(url, container, form) {
        var $cdBtnSave = $(".cd-btn-save");
        $cdBtnSave.off("click");
        $cdBtnSave.on("click", function (e) {
            var arr = $(form).serialize();
            $.post(url, arr, function (data) {
                if (data.state == "Success") {
                    $("#" + container).bootgrid("reload");
                   swal({text:data.message})
                } else {
                   swal({text:data.message})
                }
            }, 'json')

        });
    }

    //->delBtn:删除
    function delBtn(url, to) {
        var _this = to;
        $.get(url, {
            id: $(_this).attr("data-row-id")
        }, function (data) {
            $(_this).parents('tr').remove();

        }, 'json');

    }

    //->showInfo:查看编辑表单内容
    function showInfo(url, to, method) {
//        $.post(url, {
//            id: $(to).attr("data-row-id")
//        }, function (data) {
//        	var d=data.data;
//            for (var key in  d) {
//                $("#" + key).val( d[key])
//            }
//        }, 'json');
//       
        $.ajax({

        	url:url,
        	method:method,
        	type:method,
        	data:{id:$(to).attr("data-row-id")}
        }).done(function(data) {
        	var d=JSON.parse(data).data;
         
        for (var key in  d) {
            $("#" + key).val( d[key]);
            
        }} )

    }

    function treeSave(url, method, root, treeCon, param, create_text,callBack) {
        $.ajax({
            type: method,
            method: method,
            url: url,
            data: param,
            success: callBack,
            dataType: 'json'
        });

        $('#' + treeCon).jstree('reload');

    }


    function treeUpdate(url, method, treeCon, param, create_text) {
        $.ajax({
            type: method,
            method: method,
            url: url,
            data: param,
            success: function (data) {
                console.log(data);
                var ref = $('#' + treeCon).jstree(true);
                var sel = ref.get_selected();
                if (!sel.length) {
                    return false;
                }
             
                sel = sel[0];
                sel = ref.set_text(sel,   $("#" + create_text).val());
                if (sel) {
                    ref.edit(sel);
                }
            },
            dataType: 'json'
        });

        $('#' + treeCon).jstree('reload');

    }
    function treeDel(url, method, treeCon,param){
   	 var ref = $('#' + treeCon).jstree(true),sel = ref.get_selected();sel = sel[0];
  
         if (confirm("确定要删除此菜单？删除后不可恢复。")) {
             if (ref.get_children_dom(sel).length) { 
                 swal({text:"有子节点不可删除"})
             } else {
            	 $.ajax({
                     type: method,
                     method: method,
                     url: url,
                     data: param,
                     success: function (data) {
                    	    if (!sel.length) {
                                return false;
                            }
                            ref.delete_node(sel);
                           
                     },
                     dataType: 'json'
                 });
            	
             }

         }
    }
    
    function treeInfo(url, method, param) {
        $.ajax({
            type: method,
            method: method,
            url: url,
            data: param

        }).done(function (data) {
            var d = JSON.parse(data).data;
            for (var key in  d) {
                $("#" + key).val(d[key])
            }
        }).fail(function () {
        swal({text:data.message})
            })


    }

    //->把外界需要使用的方法暴露给curd
    return {
    ajax:ajax,
        cdBtnSave: cdBtnSave,
        delBtn: delBtn,
        showInfo: showInfo,
        treeSave: treeSave,
        treeInfo: treeInfo,
        treeUpdate:treeUpdate,
        treeDel:treeDel
    }
})();