<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>=
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border=1>
		<form name="myform">

			<tr>
				<th>ROLLNO</th>
				<th>USERNAME</th>
				<th>PASSWORD</th>
				<th>ADDRESS</th>
				<th>MOBNO</th>
			</tr>
			<c:forEach items="${data}" var="u">
				<tr>
					<td><input type="radio" name="rollno" value="${u.rollno }">
						<c:out value="${u.rollno }" /></td>
					<td><c:out value="${u.uname }" /></td>
					<td><c:out value="${u.upassword }" /></td>
					<td><c:out value="${u.address }" /></td>
					<td><c:out value="${u.mobno }" /></td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="button" value="Edit" onclick="editrecord()"></td>
				<td><input type="button" value="Delete" onclick="deleterecord()"></td>
				<td><input type="button" value="Add" onclick="addrecord()"></td>
				<td><input type="button" value="Pdf" onclick="pdfrecord()"></td>
		</form>
	</table>
	<script type="text/javascript">
		function editrecord() {
			alert("edit data");
			document.myform.action = "edit";
			document.myform.submit();
		}
		function deleterecord() {
			alert("delete data");
			document.myform.action = "delete";
			document.myform.submit();
		}
		function addrecord() {
			alert("add data");
			document.myform.action = "register";
			document.myform.submit();
		}
		function pdfrecord() {
			alert("pdf data");
			document.myform.action = "pdf";
			document.myform.submit();
		}
	</script>
</body>
</html>