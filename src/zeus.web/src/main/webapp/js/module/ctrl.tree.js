define([ 'jquery', 'jstree' ],
		function($, jstree) {
			var name;
			var url;
			var data;
			var plugins = [];
			var contextmenu = {
				'items' : {}
			};

			// 回调方法

			// 构造
			function ctor(gridName, dataUrl) {
				name = gridName;
				url = dataUrl;
			}

			// 设置树数据
			function setData(arg) {
				data = arg;
			}

			// 设置复选框
			function setCheckbox() {
				plugins.push('checkbox');
			}
			function setPlugin(ary) {
				plugins.push(ary);
			}
			// 添加菜单项
			function addMenuItem(id, name, icon, disable, callback) {
				if ($.inArray('contextmenu', plugins) == -1)
					plugins.push('contextmenu');

				contextmenu.items['id'] = {
					'label' : name,
					'icon' : icon,
					'_disabled' : disable,
					'action' : function(menu) {
						if ($.isFunction(callback)) {
							callback(menu);
						}
					}
				};
			}

			// 设置默认菜单
			function setDefaultMenu(addCallback, delCalback, editCallback,
					refCallback) {
				plugins.push('contextmenu');
				contextmenu.items = {
					"create" : {
						"label" : "增加",
						"icon" : "fa fa-plus",
						"_disabled" : false,
						"action" : function(item) {// item:右击菜单对象
							if ($.isFunction(addCallback)) {
								addCallback(item);
							}
						}
					},
					"remove" : {
						"label" : "删除",
						"icon" : "fa fa-times",
						"action" : function(item) {
							if ($.isFunction(delCalback)) {
								delCalback(item);
							}
						}
					},
					"rename" : {
						"label" : "编辑",
						"icon" : "fa fa-pencil",
						"_disabled" : false,
						"action" : function(item) {
							if ($.isFunction(editCallback)) {
								editCallback(item);
							}
						}

					},
					"refresh" : {
						"label" : "刷新",
						"icon" : "fa fa-refresh",
						"action" : function(item) {
							if ($.isFunction(refCallback)) {
								refCallback(item);
							}
						}
					}
				}
			}

			// 初始化树
			function init() {
				var tree = $(name).jstree({
					"core" : {
						"animation" : 0,
						"check_callback" : true,
						"themes" : {
							"stripes" : true
						},
						'data' : data
					},
					plugins : plugins,
					contextmenu : contextmenu,
				});
				return tree;
			}

			// 接口返回
			return {
				"ctor" : ctor,
				"setData" : setData,
				"setCheckbox" : setCheckbox,
				"setPlugin" : setPlugin,
				"addMenuItem" : addMenuItem,
				"setDefaultMenu" : setDefaultMenu,
				"init" : init
			};
		});