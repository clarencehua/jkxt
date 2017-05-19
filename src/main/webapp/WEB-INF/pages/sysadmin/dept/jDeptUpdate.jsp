<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>

<body>
<form name="icform" method="post">
      <input type="hidden" name="id" value="${id}"/>
      
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('deptAction_update.do','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
   修改部门
  </div> 
  

 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">上级部门：</td>
	            <td class="tableContent">
	             <!-- struts2标签默认具有自动回显     原理： 它默认会取值栈的栈顶 -->
	            	<!-- <s:select name="parent.id" list="deptList"
	            		listKey="id" listValue="deptName"
	            		headerKey="" headerValue="--请选择--"
	            	></s:select> -->
	            	<select name="dept.dept.deptId" id="parent_id">
								<option value="">请选择</option>
								<c:forEach items="${deptList}" var="li">
									<c:set var="ss" value="${li.deptId}"></c:set>
									<c:if test="${dept.deptId!=ss}">
									<option value="${li.deptId}"  <c:set var="qq" value="${dept.dept.deptId}"></c:set> <c:if test="${li.deptId==qq}">selected = "selected"</c:if> >${li.deptName}</option>
									</c:if>
								</c:forEach>
					</select>
	            </td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">部门名称：</td>
	            <td class="tableContent"><input type="text" name="dept.deptName" value="${dept.deptName }"/>
	            </td>
	        </tr>		
		</table>
	</div>
	<input type="text" hidden="true" name="dept.deptId" value="${dept.deptId}">
 </form>
</body>
</html>