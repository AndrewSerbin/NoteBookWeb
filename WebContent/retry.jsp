<%@page import="java.util.Hashtable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
             "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css">
<title>Retry</title>
</head>
<body>
	<div class="registration">
		<%
		    Hashtable errors = (Hashtable) session.getValue("errors");
		%>
		<%!
			public String getError(String s) {
				return (s == null) ? "" : s;
    		}
   		 %>
		<h1>Re-input, pls!</h1>
		<form method="post" action="RegistrationServlet">
			Name: <font color=red><%=getError((String) errors.get("name"))%></font>
			<p>
				<input type="text" name="name"
					value="<%=request.getParameter("name")%>">
			</p>
			Surname: <font color=red><%=getError((String) errors.get("surname"))%></font>
			<p>
				<input type="text" name="surname"
					value="<%=request.getParameter("surname")%>">
			</p>
			Patronymic: <font color=red><%=getError((String) errors.get("patronymic"))%></font>
			<p>
				<input type="text" name="patronymic"
					value="<%=request.getParameter("patronymic")%>">
			</p>
			nick: <font color=red><%=getError((String) errors.get("nick"))%></font>
			<p>
				<input type="text" name="nick"
					value="<%=request.getParameter("nick")%>">
			</p>
			description: <font color=red><%=getError((String) errors.get("description"))%></font>
			<p>
				<input type="text" name="description"
					value="<%=request.getParameter("description")%>">
			</p>
			group: <font color=red><%=getError((String) errors.get("group"))%></font>
			<p>
				<input type="text" name="group"
					value="<%=request.getParameter("group")%>">
			</p>
			mainTelephone: <font color=red><%=getError((String) errors.get("mainTelephone"))%></font>
			<p>
				<input type="text" name="mainTelephone"
					value="<%=request.getParameter("mainTelephone")%>">
			</p>
			spareTelephone: <font color=red><%=getError((String) errors.get("spareTelephone"))%></font>
			<p>
				<input type="text" name="spareTelephone"
					value="<%=request.getParameter("spareTelephone")%>">
			</p>
			email: <font color=red><%=getError((String) errors.get("email"))%></font>
			<p>
				<input type="text" name="email"
					value="<%=request.getParameter("email")%>">
			</p>
			skype: <font color=red><%=getError((String) errors.get("skype"))%></font>
			<p>
				<input type="text" name="skype"
					value="<%=request.getParameter("skype")%>">
			</p>
			index: <font color=red><%=getError((String) errors.get("index"))%></font>
			<p>
				<input type="text" name="index"
					value="<%=request.getParameter("index")%>">
			</p>
			city: <font color=red><%=getError((String) errors.get("city"))%></font>
			<p>
				<input type="text" name="city"
					value="<%=request.getParameter("city")%>">
			</p>
			street: <font color=red><%=getError((String) errors.get("street"))%></font>
			<p>
				<input type="text" name="street"
					value="<%=request.getParameter("street")%>">
			</p>
			houseNumber: <font color=red><%=getError((String) errors.get("houseNumber"))%></font>
			<p>
				<input type="text" name="houseNumber"
					value="<%=request.getParameter("houseNumber")%>">
			</p>
			apartmentNumber: <font color=red><%=getError((String) errors.get("apartmentNumber"))%></font>
			<p>
				<input type="text" name="apartmentNumber"
					value="<%=request.getParameter("apartmentNumber")%>">
			</p>
			<p class="submit">
				<input type="submit" name="commit" value="Отправить">
			</p>
		</form>
	</div>
</body>
</html>