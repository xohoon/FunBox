<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();
%>
<!DOCTYPE html>
<html>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<head>
<meta charset="UTF-8">
<title>LOGOUT</title>

<script type="text/javascript">
window.onload = function () {

	swal("Logout.");
	setTimeout(function() { location.href = "../Index.mb"; }, 2000);
}
</script>


</head>
<body>

</body>
</html>