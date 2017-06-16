<%@ include file="../../baselist.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html >
<head>
	<title></title>
<link rel="stylesheet" href="${ctx}/css/jquery.dataTables.min.css" type="text/css"></link>
<script type="text/javascript" src="${ctx }/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.dataTables.min.js"></script>
	<script>
	
		$(function() {
		//debugger;
		initTable();
		function initTable() {
			var table = $('#eb_table');
			var oTable = table.dataTable({
				'oLanguage' : {
					'sUrl' : '../resources/dataTables.chinese.txt'
				},
				"pageLength" : 5,
				"lengthMenu" : [ [ 5, 10, 15 ], [ 5, 10, 15 ] ],
				"bFilter" : true, //过滤功能
				"bLengthChange" : true, //改变每页显示数据数量
				"processing" : false,
				"serverSide" : true,
				"ordering" : false,
				"deferRender" : true,
				"bAutoWidth": false,
				"ajax" : {
					"type" : "post",
					"url" : "getDataTablesUser.aj",
					"dataSrc" : "data",
					"data" : function(data) {
						var param = {};
						param.start = data.start;
						param.pageLength = data.length;
						param.search = data.search;
						return param;
					}
				},
				"columns" : [ {
					"data" : function(data) {
						var html='<input type="checkbox" name="id" value= '+data.userId+'>';
						return html;
					}
				}, {
					"data" : "userId"
				}, {
					"data" : "userName"
				}, {
					"data" : "state"
				}],
				"fnDrawCallback" : function(settings) {
				}

			});
		}
		
	});
	
	
	     function isOnlyChecked(){
	    	 var checkBoxArray = document.getElementsByName('id');
				var count=0;
				for(var index=0; index<checkBoxArray.length; index++) {
					if (checkBoxArray[index].checked) {
						count++;
					}	
				} 
			//jquery
			//var count = $("[input name='id']:checked").size();
			if(count==1)
				return true;
			else
				return false;
	     }
	     function toView(){
	    	 if(isOnlyChecked()){
	    		 formSubmit('userAction_toview.do','_self');
	    	 }else{
	    		 alert("请先选择一项并且只能选择一项，再进行操作！");
	    	 }
	     }
	     //实现更新
	     function toUpdate(){
	    	 if(isOnlyChecked()){
	    		 formSubmit('userAction_toupdate.do','_self');
	    	 }else{
	    		 alert("请先选择一项并且只能选择一项，再进行操作！");
	    	 }
	     }
	</script>
</head>

<body>
<form name="icform" method="post">
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="view"><a href="javascript:toView()">查看</a></li>
<li id="new"><a href="#" onclick="formSubmit('userAction_tocreate.do','_self');this.blur();">新增</a></li>
<li id="update"><a href="#" onclick="javascript:toUpdate()">修改</a></li>
<li id="update"><a href="#" onclick="formSubmit('userAction_torole.do','_self');this.blur();">角色</a></li>
<li id="delete"><a href="#" onclick="formSubmit('userAction_delete.do','_self');this.blur();">删除</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
     用户列表
  </div> 
  </div>
  </div>
  
<div>


<div class="eXtremeTable" >
<table id="eb_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<th class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></th>
		<th class="tableHeader">序号</th>
		<th class="tableHeader">用户名</th>
		<th class="tableHeader">状态</th>
	</tr>
	</thead>
	<tbody class="tableBody" >

	
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

