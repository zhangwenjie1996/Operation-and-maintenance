$(function () {
	jQuery.i18n.properties({//加载资浏览器语言对应的资源文件
		name:'strings', //资源文件名称
		path:'src/i18n/', //资源文件路径
		mode:'map', //用Map的方式使用资源文件中的值
		language : '',
		callback: fn
	});
	function fn() {//加载成功后设置显示内容
		$('.page-header h2').html($.i18n.prop('Page header'));
		$('#userName').html($.i18n.prop('userName'));
		$('#EmailAddress').html($.i18n.prop('Email address'));
		$('#Password').html($.i18n.prop('Password'));
		$('#Login').html($.i18n.prop('Login'));

		$('#loginUser').attr("data-bv-message",$.i18n.prop('loginUser Validator'));
		$('#loginUser').attr("data-bv-notempty-message",$.i18n.prop('loginUser Validator empty'));
		$('#loginUser').attr("data-bv-regexp-message",$.i18n.prop('loginUser  Validator regExp'));
		$('#loginUser').attr("data-bv-stringlength-message",$.i18n.prop('loginUser Validator length'));
		$('#loginEmail').attr("data-bv-emailaddress-message",$.i18n.prop('loginEmail Validator '));
		$('#loginEmail').attr("data-bv-notempty-message",$.i18n.prop('loginEmail Validator empty'));
		$('#loginPass').attr("data-bv-notempty-message",$.i18n.prop('loginPass Validator empty'));
		$('#button_login').html($.i18n.prop('Login'));
	}
});
