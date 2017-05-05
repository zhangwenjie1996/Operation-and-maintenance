define([], function () {
    'use strict';
    var map = {
        device: {
            url: 'http://localhost:8080/web/',
            children: {
                materialCategory: {
                    url: 'MaterialCategoryController/',
                    children: {
                        findCategoryTree: {
                            url: 'findCategoryTree'
                        },
                        findMultiCondition:{
                            url:'findMultiCondition'
                        }
                    }
                }
            }
        }
    }

    //根据key数组获取url字符串
    function getUrl(keys) {
        var url = '';
        var thisMap = map;
        for (var i = 0; i < keys.length; i++) {
            url += thisMap[keys[i]].url;
            thisMap = thisMap[keys[i]].children;
            if(!thisMap){
              continue;
            }
        }
        return url;
    }

    return {
        map:map,
        getUrl: getUrl
    };
});