<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
table, tr, th, td {
	boder: 2px;
	border-collapse: collapse;
	background-color: lightgreen;
	padding: 10px;
	text-align: center;
}
</style>
<body>
	<div align="center">
		<form action="firsturl">
			<table>
				<tr >
					<th colspan="2"><h1 style="color: green">Details for
							Matrimony</h1></th>

				</tr>
				<td>Person name :</td>
				<td><input type="text" name="pname" /></td>
				</tr>

				</tr>
				<td>Father name :</td>
				<td><input type="text" name="fname" /></td>
				</tr>


				</tr>
				<td>Marital status :</td>
				<td><input type="radio" name="mstatus" checked="checked" value="single"/>
					Single &nbsp; <input type="radio" name="mstatus" value="married"/> Married</td>
				</tr>

				<tr>
					<td><input type="submit" value="continue" /></td>
				</tr>

			</table>
		</form>
	</div>
</body>
</html>