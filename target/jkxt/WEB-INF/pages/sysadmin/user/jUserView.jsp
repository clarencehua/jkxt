<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>

<body>
<form name="icform" method="post">
      <input type="hidden" name="id" value="${user.userId}"/>
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
	            	${user.dept.deptName }
	            </td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">用户名：</td>
	            <td class="tableContent">${user.userName }</td>
	        </tr>	
	         <tr>
	            <td class="columnTitle">状态：</td>
	            <c:if test="${user.state==0}"><td class="tableContent">停用</td></c:if>
	            <c:if test="${user.state==1}"><td class="tableContent">启用</td></c:if>
	        </tr>		
		</table>
	</div>
 </form>
</body>
</html>