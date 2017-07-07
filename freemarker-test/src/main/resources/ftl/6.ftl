<!DOCTYPE html>
<html>
	<head>
		<title>freemarker</title>
		<meta charset="UTF-8"/>
		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"/>
	</head>
	<body>
		<#-- 内置函数 -->
		int: ${12.899?int} <br/>
		string格式化小数: ${12.997?string('##.##')} <br/>
		string格式化小数(小数点必须为两位，不够用0代替): ${12.997?string('##.00')} <br/>
		
		转化成大写字母：${'itcast'?upper_case} <br/>
		转化成小写字母：${'SPRING'?lower_case} <br/>
		去掉字符串前后空格: ${'  中国    '?trim} <br/>
		
		<#assign str=' 123 '/>
		<#if '123'=str?trim>
			进入
		</#if>
		
		字符串截取: <br/>
		<#assign str="freemarker"/>
		截取0-4: ${str[0..4]}<br/>
		截取0-4(小于4): ${str[0..<4]}<br/>
		截取0-100但小于100，如果长度不够100，取最后位数: ${str[0..*100]}<br/>
		截取2至最后一位长度: ${str[2..]}<br/>
		
		<hr/>
		date日期: ${"2017-09-08"?date('yyyy-MM-dd')?string('yyyy年MM月dd日')} <br/>
		
	</body>
</html>