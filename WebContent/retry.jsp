<%@page import="servlet.util.BundleConstants"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Hashtable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
             "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css">
<%
    ResourceBundle bundle = (ResourceBundle) session.getAttribute("bundle");
%>
<title><%=bundle.getString(BundleConstants.RETRY)%></title>
</head>
<body>
	<section class="container">
	<div class="registration">
		<%
		    Hashtable errors = (Hashtable) session.getValue("errors");
		%>
		<%!public String getError(String s) {
	return (s == null) ? "" : s;
    }%>
		<h1><%=bundle.getString(BundleConstants.RE_INPUT)%></h1>
		<form method="post" action="RegistrationServlet">
			<%=bundle.getString(BundleConstants.NAME)%>
			<font color=red><%=getError((String) errors.get("name"))%></font>
			<p>
				<input type="text" name="name"
					value="<%=request.getParameter("name")%>">
			</p>
			<%=bundle.getString(BundleConstants.SURNAME)%>
			<font color=red><%=getError((String) errors.get("surname"))%></font>
			<p>
				<input type="text" name="surname"
					value="<%=request.getParameter("surname")%>">
			</p>
			<%=bundle.getString(BundleConstants.PATRONYMIC)%>
			<font color=red><%=getError((String) errors.get("patronymic"))%></font>
			<p>
				<input type="text" name="patronymic"
					value="<%=request.getParameter("patronymic")%>">
			</p>
			<%=bundle.getString(BundleConstants.NICK)%>
			<font color=red><%=getError((String) errors.get("nick"))%></font>
			<p>
				<input type="text" name="nick"
					value="<%=request.getParameter("nick")%>">
			</p>
			<%=bundle.getString(BundleConstants.DESCRIPTION)%>
			<font color=red><%=getError((String) errors.get("description"))%></font>
			<p>
				<input type="text" name="description"
					value="<%=request.getParameter("description")%>">
			</p>
			<%=bundle.getString(BundleConstants.GROUP)%>
			<font color=red><%=getError((String) errors.get("group"))%></font>
			<p>
				<input type="text" name="group"
					value="<%=request.getParameter("group")%>">
			</p>
			<%=bundle.getString(BundleConstants.MAIN_TELEPHONE)%>
			<font color=red><%=getError((String) errors.get("mainTelephone"))%></font>
			<p>
				<input type="text" name="mainTelephone"
					value="<%=request.getParameter("mainTelephone")%>">
			</p>
			<%=bundle.getString(BundleConstants.SPARE_TELEPHONE)%>
			<font color=red><%=getError((String) errors.get("spareTelephone"))%></font>
			<p>
				<input type="text" name="spareTelephone"
					value="<%=request.getParameter("spareTelephone")%>">
			</p>
			<%=bundle.getString(BundleConstants.EMAIL)%>
			<font color=red><%=getError((String) errors.get("email"))%></font>
			<p>
				<input type="text" name="email"
					value="<%=request.getParameter("email")%>">
			</p>
			<%=bundle.getString(BundleConstants.SKYPE)%>
			<font color=red><%=getError((String) errors.get("skype"))%></font>
			<p>
				<input type="text" name="skype"
					value="<%=request.getParameter("skype")%>">
			</p>
			<%=bundle.getString(BundleConstants.INDEX)%>
			<font color=red><%=getError((String) errors.get("index"))%></font>
			<p>
				<input type="text" name="index"
					value="<%=request.getParameter("index")%>">
			</p>
			<%=bundle.getString(BundleConstants.CITY)%>
			<font color=red><%=getError((String) errors.get("city"))%></font>
			<p>
				<input type="text" name="city"
					value="<%=request.getParameter("city")%>">
			</p>
			<%=bundle.getString(BundleConstants.STREET)%>
			<font color=red><%=getError((String) errors.get("street"))%></font>
			<p>
				<input type="text" name="street"
					value="<%=request.getParameter("street")%>">
			</p>
			<%=bundle.getString(BundleConstants.HOUSE_NUMBER)%>
			<font color=red><%=getError((String) errors.get("houseNumber"))%></font>
			<p>
				<input type="text" name="houseNumber"
					value="<%=request.getParameter("houseNumber")%>">
			</p>
			<%=bundle.getString(BundleConstants.APARTMENT_NUMBER)%>
			<font color=red><%=getError((String) errors.get("apartmentNumber"))%></font>
			<p>
				<input type="text" name="apartmentNumber"
					value="<%=request.getParameter("apartmentNumber")%>">
			</p>
			<p class="submit">
				<input type="submit" name="commit"
					value="<%=bundle.getString(BundleConstants.SEND)%>">
			</p>
		</form>
	</div>
	</section>
</body>
</html>