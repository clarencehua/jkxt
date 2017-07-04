<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>

<body>
<form name="icform" method="post">
      <input type="hidden" name="user.userId" value="${user.userId}"/>
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('userAction_update.do','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
   查看用户
  </div> 
  

 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">所在部门：</td>
	             <td class="tableContent">
	            <!-- 	<s:select name="dept.id" list="deptList"
	            		listKey="id" listValue="deptName"
	            		headerKey="" headerValue="--请选择--"
	            	></s:select> -->
	            	<select name="user.dept.deptId" id="parent_id">
								<option value="">请选择</option>
								<c:forEach items="${deptList}" var="li">
									<c:set var="ss" value="${li.deptId}"></c:set>5
									<c:if test="${dept.deptId!=ss}">
									<option value="${li.deptId}"  <c:set var="qq" value="${user.dept.deptId}"></c:set> <c:if test="${li.deptId==qq}">selected = "selected"</c:if> >${li.deptName}</option>
									</c:if>
								</c:forEach>
					</select>
	            </td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">用户名：</td>
	            <td class="tableContent"><input type="text" name="user.userName" value="${user.userName }"/></td>
	        </tr>	
	         <tr>
	            <td class="columnTitle">状态：</td>
	            <td class="tableContentAuto">
	              <input type="radio" name="user.state" class="input" <c:if test="${user.state==0}">checked = "checked"</c:if> value="0">停用 
	              <input type="radio" name="user.state" class="input"  <c:if test="${user.state==1}">checked = "checked"</c:if> value="1">启用 
	            </td>
	        </tr>		
		</table>
	</div>
 </form>
</body>
</html>