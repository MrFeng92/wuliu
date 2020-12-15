<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>

<body>
<form name="icform" method="post">
	<!-- 通过input来取部门的主键值，目的是在更新保存的时候，把部门的主键值传给后台，注意
	这步操作很容易遗漏，结果部门的主键值传丢了 -->
	<input type="hidden" name="deptId" value="${deptInfo.deptId }"/>

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="save"><a href="#" onclick="formSubmit('update','_self');this.blur();">保存</a></li>
	<li id="back"><a href="#" onclick="history.go(-1);return false;this.blur();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    部门修改
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<!-- 更新部门名称、上级部门 -->
<!-- 部门回显，所以value -->
部门名称：<input type="text" name="deptName" value="${deptInfo.deptName }"/>
父部门：
<select name="parentId">
	<option>--请选择--</option>
	<c:forEach items="${dataList }" var="dept">
		<option value="${dept.deptId}">${dept.deptName }</option>
	</c:forEach>
</select>
	
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

