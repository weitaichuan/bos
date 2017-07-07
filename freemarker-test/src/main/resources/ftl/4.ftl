<!DOCTYPE html>
<html>
	<head>
		<title>freemarker</title>
		<meta charset="UTF-8"/>
		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"/>
	</head>
	<body>
		<#-- 变量指令 -->
		<#-- 数值类型 -->
		<#assign age=40.5/>
		数值age: ${age} <br/>
		
		<#-- 字符串类型 -->
		<#assign str='itcast'/>
		字符串str: ${str} <br/>
		
		<#-- 布尔类型 -->
		<#assign sex=true/>
		布尔sex: ${sex?string('男','女')} <br/>
		
		<#assign sex2=!(1=1)/>
		布尔sex2: ${sex2?string('男','女')} <br/>
		
		<#-- 列表与数组类型 -->
		<#assign nums=[10,20,30,40,50]/>
		<ul>
			<#list nums as num>
				<li>元素值：${num}, 索引号：${num_index}</li>
			</#list>
		</ul>
		<#assign strs=['lucene','solr','activemq','freemarker']/>
		<ol>
			<#list strs as str>
				<li>元素值：${str}, 索引号：${str_index}</li>
			</#list>
		</ol>
		<#assign arrs=1..10/>
		<ol>
			<#list arrs as num>
				<li>元素值：${num}, 索引号：${num_index}</li>
			</#list>
		</ol>
		
		<#-- Map集合 -->
		<#assign maps={'id':1,'name':'李小明','age':20}/>
		<#-- 按key的方式迭代 -->
		<#list maps?keys as key>
			${key} --> ${maps[key]} <br/>
		</#list>
		
		<#-- 按value的方式迭代 -->
		<#list maps?values as value>
			${value}  <br/>
		</#list>
		
		
	</body>
</html>