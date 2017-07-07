<!DOCTYPE html>
<html>
	<head>
		<title>freemarker</title>
		<meta charset="UTF-8"/>
		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"/>
	</head>
	<body>
		<#-- 取值${} 注释 -->
		数值类型id: ${user.id} <br/>
		字符串类型name: ${user.name} <br/>
		数值类型age: ${user.age}<br/>
		布尔性别sex: ${user.sex?string('男','女')} <br/>
		日期birthday: ${user.birthday?string('yyyy年MM月dd日 HH:mm:ss')} <br/>
		
		当前时间：${.now} <br/>
		
		<hr/>
		
		数值类型id: ${user['id']} <br/>
		字符串类型name: ${user['name']} <br/>
		数值类型age: ${user['age']}<br/>
		布尔性别sex: ${user['sex']?string('男','女')} <br/>
		日期birthday: ${user['birthday']?string('yyyy年MM月dd日 HH:mm:ss')} <br/>
		
	</body>
</html>