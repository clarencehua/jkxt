<%@ include file="../../baselist.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<title></title>
<link rel="stylesheet" href="${ctx}/css/jquery.dataTables.min.css" type="text/css"></link>
<script type="text/javascript" src="${ctx }/js/jquery-1.11.2.min.js"></script> 
<script type="text/javascript" src="${ctx }/js/jquery.dataTables.min.js"></script>

<script>
		$(function() {
		initTable();
		function initTable() {
			var table = $('#ec_table');
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
					"url" : "getDataTablesDept.aj",
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
						var html='<input type="checkbox" name="id" value= '+data.deptId+'>';
						return html;
					}
				}, {
					"data" : "deptId"
				}, {
					"data" : "deptId"
				}, {
					"data" : "fdeptName"
				}, {
					"data" : "deptName"
				}],
				"fnDrawCallback" : function(settings) {
				}

			});
		}
		
	});

	function isOnlyChecked() {
	
		var checkBoxArray = document.getElementsByName('id');
		var count = 0;
		for ( var index = 0; index < checkBoxArray.length; index++) {
			if (checkBoxArray[index].checked) {
				count++;
			}
		}
		//jquery
		//var count = $("[input name='id']:checked").size();
		if (count == 1)
			return true;
		else
			return false;
	}
	function toView() {
		if (isOnlyChecked()) {
			formSubmit('deptAction_toview.do', '_self');
		} else {
			alert("请先选择一项并且只能选择一项，再进行操作！");
		}
	}
	//实现更新
	function toUpdate() {
		if (isOnlyChecked()) {
			formSubmit('deptAction_toupdate.do', '_self');
		} else {
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
							<li id="view"><a href="#" onclick="javascript:toView()">查看</a>
							</li>
							<li id="new"><a href="#"
								onclick="formSubmit('deptAction_tocreate.do','_self');this.blur();">新增</a>
							</li>
							<li id="update"><a href="#" onclick="javascript:toUpdate()">修改</a>
							</li>
							<li id="delete"><a href="#"
								onclick="formSubmit('deptAction_delete.do','_self');this.blur();">删除</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="textbox" id="centerTextbox">
			<div class="textbox-header">
				<div class="textbox-inner-header">
					<div class="textbox-title">部门列表</div>
				</div>
			</div>

			<div>


				<div class="eXtremeTable">
					<table id="ec_table" class="tableRegion" width="98%">
						<thead>
							<tr>
								<td class="tableHeader"><input type="checkbox" name="selid"
									onclick="checkAll('id',this)"></td>
								<td class="tableHeader">序号</td>
								<td class="tableHeader">编号</td>
								<td class="tableHeader">上级</td>
								<td class="tableHeader">名称</td>
							</tr>
						</thead>
						<tbody class="tableBody">

							<%-- ${links }
	<c:forEach items="${results }" var="dept" varStatus="st">
		<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
			<td><input type="checkbox" name="id" value="${dept.id }"/></td>
			<td>${st.count }</td>
			<td>${dept.id }</td>
			<td>${dept.parent.deptName }</td>
			<td><a href="deptAction_toview?id=${dept.id }">${dept.deptName }</a></td>
		</tr>
	</c:forEach> --%>

						</tbody>
					</table>
				</div>

			</div>
	</form>
</body>
</html>

