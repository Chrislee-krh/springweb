<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>loginPage</title>
	</head>
	<body>
		<div>
			<form action="sessionLogin" method="post">
				<input type="text" name="id" placeholder="id"><br>
				<input type="text" name="pw" placeholder="pw"><br>
				
				<input type="submit" value="login">
				<input type="button" value="cancel" onclick="location.href='mainPage'">
			</form>
			<p style="color: red">${msg}</p>
		</div>
	</body>
</html>