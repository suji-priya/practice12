<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
		<form action="update">
			<tr>
				<td>ROLLNO:</td>
				<td><input type="hidden" name="rollno" value="${stu.rollno}"></td>
			</tr>
			<tr>
				<td>USERNAME:</td>
				<td><input type="text" name="uname" value="${stu.uname }"></td>
			</tr>
			<tr>
				<td>PASSWORD:</td>
				<td><input type="password" name="upassword"  value="${stu.upassword }"></td>
			</tr>
			<tr>
				<td>ADDRESS:</td>
				<td><input type="text" name="address"  value="${stu.address }"></td>
			</tr>
			<tr>
				<td>MOBNO:</td>
				<td><input type="text" name="mobno"value="${stu.mobno }"></td>
			</tr>

			<tr>
				<td><input type="submit" value="Update"></td>
			</tr>
			
		</form>
	</table>
</body>
</html>