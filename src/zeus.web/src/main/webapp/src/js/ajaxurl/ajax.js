//->使用惰性思想封装的一个获取AJAX对象的方法
var getXHR = function () {
    var list = [
        function () {
            return new XMLHttpRequest;//->IE7+、标准浏览器
        }, function () {
            return new ActiveXObject("Microsoft.XMLHTTP");
        }, function () {
            return new ActiveXObject("Msxml2.XMLHTTP");
        },
        function () {
            return new ActiveXObject("Msxml3.XMLHTTP");
        }
    ];
    var temp = null;
    for (var i = 0; i < list.length; i++) {
        var tempFn = list[i];
        try {
            temp = tempFn();
        } catch (e) {
            continue;
        }
        getXHR = tempFn;
        break;
    }
    if (!temp) {
        throw new Error("您的当前浏览器不支持AJAX!");
    }
    return temp;
};

//->apiurl:服务器端请求的接口地址
//->callback:请求成功后要处理的事情
function ajaxReq(apiurl, type, isAsync, reqbody, callback) {
    var XHRequest = getXHR();
    //->添加一个随机数清除缓存
    apiurl += apiurl.indexOf("?") > -1 ? "&_=" + Math.random() : "?_=" + Math.random();
    XHRequest.open(type, apiurl, isAsync);
    XHRequest.onreadystatechange = function () {
        if (XHRequest.readyState === 4 && /^2\d{2}$/.test(XHRequest.status)) {
            var val = XHRequest.responseText;
            val = "JSON" in window ? JSON.parse(val) : eval("(" + val + ")");
            callback(val);
        }
    };
    XHRequest.send(reqbody);
}
//获取url
var data = {
    "A": {
        "address": "http://localhost:8080/web/"
    },
    "B": {
        "address": "/deleteInfo"

    },
    "C": {
        "address": "/detailInfo"

    },
    "D": {
        "address": "/addInfo"
    },
    "E": {
        "address": "/updateInfo"
    }

};

//var a = {
//    "view": '<a abs="查看" class="btn-color btn btn-xs btn-default command-view" data-row-id="' + row[idname] + '"><span class="fa  fa-eye"></span></a>',
//    "edit": '<a  abs="编辑" class="btn-color btn btn-xs btn-default command-edit" data-row-id="' + row[idname] + '"><span class="glyphicon glyphicon-pencil"></span></a> ',
//    "delete": '<a  abs="删除" class="btn-color btn btn-xs btn-default command-delete" data-row-id="' + row[idname] + '"><span class="glyphicon glyphicon-trash"></span></a>'
//};
//
//function formatters(m) {
//    for (var key in a) {
//        if (a.hasOwnProperty(key)) {
//            if (key == m) {
//                return a[key];
//            }
//        }
//    }
//}
function getUrl(routeK) {
    for (var key in data) {
        if (data.hasOwnProperty(key)) {
            if (key == routeK) {
                return data[key].address;
            }
        }
    }
}
////页面调用写法
//var parameter = "" ;
//parameter = encodeURIComponent(parameter);
//ajaxReq(data.A ,"post",true,{age:1,name:2}, function (data) {
//
//
//});
//ajaxReq(getUrl("B") +"?"+ parameter,"get",true, function (data) {
//
//
//});

