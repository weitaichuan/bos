<!DOCTYPE html>
<html>
	<head>
		<title>freemarker</title>
		<meta charset="UTF-8"/>
		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"/>
	</head>
	<body>
		<#-- 处理空值 -->
		name为空时不显示：${name!} <br/>
		name为空时显示默认信息：${name!'李小华'} <br/>
		
		用两个??判断name是否为空: ${name???string('不是空','空')} <br/>
		
		<#if name??>
			name不为空
		</#if>
		
		
		<hr/>
		<#-- 自定义指令 -->
		<#macro say name age>
			${name}，您好，年龄为: ${age}!
		</#macro>
		
		<@say name="李中华" age=21/>
		
		<#macro foreach array>
			<ul>
			   <#list array as arr>
			      <li>${arr}</li>
			   </#list>
			</ul>
		</#macro>
		
		<@foreach array=[10,20,30,40]/>
	</body>
</html>