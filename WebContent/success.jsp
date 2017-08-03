<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration successful</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="registration">
		<h1>SUCCESS!!!</h1>
		Name: <%=request.getParameter("name")%><br>
		surname: <%=request.getParameter("surname")%><br>
		patronymic: <%=request.getParameter("patronymic")%><br>
		nick: <%=request.getParameter("nick")%><br>
		group: <%=request.getParameter("group")%><br>
		mainTelephone: <%=request.getParameter("mainTelephone")%><br>
		spareTelephone: <%=request.getParameter("spareTelephone")%><br>
		email: <%=request.getParameter("email")%><br>
		skype: <%=request.getParameter("skype")%><br>
		index: <%=request.getParameter("index")%><br>
		city: <%=request.getParameter("city")%><br>
		street: <%=request.getParameter("street")%><br>
		houseNumber: <%=request.getParameter("houseNumber")%><br>
		apartmentNumber: <%=request.getParameter("apartmentNumber")%><br>
	</div>
</body>
</html>