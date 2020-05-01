<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CookiesApp</title>
</head>
<body>
	<div align="center">
	<h1 style="color:red;text-align:center"> Session Tracking using Browser Cookies</h1>
		<form action="firsturl" method="post">
		<table>
		<tr>
		<td>Name :  </td>
		<td><input type="text" name="name"/></td>
		</tr>
		
		<tr>
		<td>Father name :  </td>
		<td><input type="text" name="fname"/></td>
		</tr>
		
		<tr>
		<td>Gender :  </td>
		<td><input type="radio" name="gender" value="male"/> Male &nbsp; &nbsp;
		<input type="radio" name="gender" value="female" checked="checked"/> Female 
		</td>
		</tr>
		
		<tr>
		<td colspan="2">
		<input type="submit" value="continue"/>
		</td>
		</tr>
		</table>	

		</form>
	</div>
</body>
</html>