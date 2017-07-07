<!DOCTYPE html>
<html>
	<head>
		<title>freemarker</title>
		<meta charset="UTF-8"/>
		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"/>
	</head>
	<body>
		<#-- 表达式与运算运 -->
		<#-- 算术运算符：+、-、*、/、% -->
		${(10 + 10 - 10) * 10 / 10} <br/>
		${ 10 % 3} <br/>
		
		<#--  比较运算符：==、!=、lte 、<=、lt 、<、gte、 >=、gt 、 > -->
		${(10 == 10)?string('yes', 'no')} <br/>
		${(10 != 10)?string('yes', 'no')} <br/>
		
		${(10 lte 10)?string('yes', 'no')} <br/>
		${(10 <= 10)?string('yes', 'no')} <br/>
		${(10 lt 10)?string('yes', 'no')} <br/>
		${(10 < 10)?string('yes', 'no')} <br/>
		
		
		${(10 gte 10)?string('yes', 'no')} <br/>
		${(10 >= 10)?string('yes', 'no')} <br/>
		
		${(10 gt 10)?string('yes', 'no')} <br/>
		${(10 > 10)?string('yes', 'no')} <br/>
		
		<hr/>
		<#-- 逻辑运算符：||、&&、! -->
		${(10 == 10 || 20 == 30)?string('yes','no')} <br/>
		${(10 == 10 && 20 == 30)?string('yes','no')} <br/>
		
		${(!(10 == 10 && 20 == 30))?string('yes','no')} <br/>
		
		<#-- 数值范围：${(1..10)?size} -->
		${(1..10)?size} <br/>
		
	
	</body>
</html>