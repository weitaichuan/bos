<!DOCTYPE html>
<html>
	<head>
		<title>freemarker</title>
		<meta charset="UTF-8"/>
		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"/>
	</head>
	<body>
		<#-- 条件指令  if ... elseif ... else -->
		<#assign age=50/>
		<#-- if -->
		<#if age gte 50>
			老年人
		</#if>
		<br/>
		<#-- if ... else -->
		<#if age gt 50>
			老年人
		<#else>
		          中年人
		</#if>
		
		<br/>
		<#-- if ... elseif ... else -->
		<#if age gt 50>
			老年人
		<#elseif age gt 30>
		         中年人 elseif
		<#else>
		       青年人     
		</#if>
		<br/>
		
		<#-- 循环指令  list -->
		<#list [10,20,30,40] as num>
			${num} <br/>
		</#list>
		<hr/>
		<#list 1..10 as num>
			${num} <br/>
		</#list>
		<hr/>
		<#list ['a','b','c'] as str>
			${str} <br/>
		</#list>
		
		<hr/>
		<#assign nums=[100,200,300,400]/>
		<#-- 迭代指定范围元素 -->
		<#list nums[0..2] as num>
		    ${num} <br/>
		</#list>
		
		<br/>
	    <#-- 迭代用户集合 -->
		<table border="1" width="50%">
			<#list users as u>
				<tr>
				    <td>${u.id}</td>
				    <td>${u.name}</td>
				    <td>${u.age}</td>
				    <td>${u.sex?string('男','女')}</td>
				    <td>${u.birthday?string('yyyy-MM-dd')}</td>
				</tr>
			</#list>
		</table>
		
		
		<#-- 包含指令 -->
		<#include 'footer.ftl'/>
		
	</body>
</html>