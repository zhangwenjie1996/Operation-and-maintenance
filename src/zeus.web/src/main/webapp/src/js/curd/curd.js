 
var curd = (function () {    
	  function ajax(url,method,param,async,doneCallBack,failCallBack){  
	       $.ajax({
          type: method,
          method: method,
          url: url,
          data: param,
          async:async

      }).done(function (data) {
    	  doneCallBack(data);
      }).fail(function (data) {
    	  failCallBack(data);
          })  
  }
    //->cdBtnSave:表单保存
    function saveBtn(container,url, method,param,async) { 
    	curd.ajax(url,method,param,async, function (data) {
           	  $("#"+container).bootgrid("reload");	
           	 swal({text:data.message}) ;
            
            },function (data) {
            	 swal({text:data.message}) ;
            })
     
    }
    //->delBtn:删除
    function delBtn(url,to) {
    
        var _this = to;
        swal({text:"删除第"+ $(this).attr("data-row-id")+"行"}); 
        $.get(url, {
            id: $(_this).attr("data-row-id")
        }, function (data) {
            $(_this).parents('tr').remove();
        }, 'json');

    }
    //->showInfo:查看编辑表单内容
    function showInfo(url,method,param,async) {
    	curd.ajax(url,method,param,async ,function (data) {
            var d = JSON.parse(data).data;
            for (var key in  d) {
                $("#" + key).val(d[key])
                if(key=="unitsID"){
          			var all_options=document.getElementById("unitsID").options;
                   	 for (i=0; i<all_options.length; i++){
                   		 if (all_options[i].value == d[key]){
                   			 all_options[i].selected = true;
                   		 }
                   	 }
          		 }
                if(key=="unitsIDs"){
          			var all_options=document.getElementById("unitsIDs").options;
                   	 for (i=0; i<all_options.length; i++){
                   		 if (all_options[i].value == d[key]){
                   			 all_options[i].selected = true;
                   		 }
                   	 }
          		 }
            }
        },function (data) {
            swal({text:data.message}) ;
        })
    }


    //->把外界需要使用的方法暴露给curd
    return {
    	ajax:ajax,
    	saveBtn: saveBtn,
        delBtn: delBtn,
        showInfo: showInfo
    }
})();