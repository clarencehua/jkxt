<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>

<body>
<form name="icform" method="post">
	 <input type="hidden" name="module.moduleId" value="${module.moduleId}"/> 

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('moduleAction_update.do','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
   修改模块
  </div> 
  </div>
  </div>
  

 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">模块名：</td>
	            <td class="tableContent"><input type="text" name="module.name" value="${module.name}"/></td>
	            <td class="columnTitle">层数：</td>
	            <td class="tableContent"><input type="text" name="module.layerNum" value="${module.layerNum}"/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">权限标识：</td>
	            <td class="tableContent"><input type="text" name="module.cpermission" value="${module.cpermission}"/></td>
	            <td class="columnTitle">链接：</td>
	            <td class="tableContent"><input type="text" name="module.curl" value="${module.curl}"/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">类型：</td>
	            <td class="tableContentAuto">
	            	<input type="radio" name="module.ctype" value="0" <c:if test="${module.ctype==0}">checked</c:if> class="input"/>主菜单
	            	<input type="radio" name="module.ctype" value="1" <c:if test="${module.ctype==1}">checked</c:if> class="input"/>左侧菜单
	            	<input type="radio" name="module.ctype" value="2" <c:if test="${module.ctype==2}">checked</c:if> class="input"/>按钮
	            	<input type="radio" name="module.ctype" value="3" <c:if test="${module.ctype==3}">checked</c:if> class="input"/>链接
	            	<input type="radio" name="module.ctype" value="4" <c:if test="${module.ctype==4}">checked</c:if> class="input"/>状态
	            </td>
	            <td class="columnTitle">状态：</td>
	            <td class="tableContentAuto">
	            	<input type="radio" name="module.state" value="1" <c:if test="${module.state==1}">checked</c:if> class="input"/>启用
	            	<input type="radio" name="module.state" value="0" <c:if test="${module.state==0}">checked</c:if> class="input"/>停用
	            </td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">从属：</td>
	            <td class="tableContent"><input type="text" name="module.belong" value="${module.belong}"/></td>
	            <td class="columnTitle">复用标识：</td>
	            <td class="tableContent"><input type="text" name="module.cwhich" value="${module.cwhich}"/></td>
	        </tr>			
	        <tr>
	            <td class="columnTitle">说明：</td>
	            <td class="tableContent">
	            	<textarea name="module.remark" style="height:120px;">${module.remark}</textarea>
	            </td>
	            <td class="columnTitle">排序号：</td>
	            <td class="tableContent"><input type="text" name="orderNo" value="${module.orderNo}"/></td>
	        </tr>			
		</table>
	</div>
 
 
</form>
</body>
</html>

