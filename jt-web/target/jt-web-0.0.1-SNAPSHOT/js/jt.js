var TT = JT = {
	checkLogin : function(){
		//获取指定名称的cookie
		var _ticket = $.cookie("JT_TICKET");
		if(!_ticket){
			return ; //如果数据为null则直接return
		}
		//当dataType类型为jsonp时，jQuery就会自动在请求链接上增加一个callback的参数
		$.ajax({
			url : "http://www.jt.com/user/query/" + _ticket,
			dataType : "jsonp",
			type : "GET",
			success : function(data){
				if(data.status == 200){
					//把json串转化为js对象
					//data.data=获取userJSON字符串
					var _data = JSON.parse(data.data);
					var html =_data.username+"，欢迎来到京淘！<a href=\"http://www.jt.com/user/logout.html\" class=\"link-logout\">[退出]</a>";
					$("#loginbar").html(html);
				}
			}
		});
	}
}

$(function(){
	// 查看是否已经登录，如果已经登录查询登录信息
	TT.checkLogin();
});