<%@page import="servlet.util.BundleConstants"%>
<%@page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
    ResourceBundle bundle = (ResourceBundle) session.getAttribute("bundle");
%>
<title><%=bundle.getString(BundleConstants.SUCCESS)%></title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<section class="container">
	<div class="registration">
		<h1><%=bundle.getString(BundleConstants.SUCCESS)%></h1>
		<%=bundle.getString(BundleConstants.NAME)%><%=request.getParameter("name")%><br>
		<%=bundle.getString(BundleConstants.SURNAME)%><%=request.getParameter("surname")%><br>
		<%=bundle.getString(BundleConstants.PATRONYMIC)%><%=request.getParameter("patronymic")%><br>
		<%=bundle.getString(BundleConstants.NICK)%><%=request.getParameter("nick")%><br>
		<%=bundle.getString(BundleConstants.DESCRIPTION)%><%=request.getParameter("description")%><br>
		<%=bundle.getString(BundleConstants.GROUP)%><%=request.getParameter("group")%><br>
		<%=bundle.getString(BundleConstants.MAIN_TELEPHONE)%><%=request.getParameter("mainTelephone")%><br>
		<%=bundle.getString(BundleConstants.SPARE_TELEPHONE)%><%=request.getParameter("spareTelephone")%><br>
		<%=bundle.getString(BundleConstants.EMAIL)%><%=request.getParameter("email")%><br>
		<%=bundle.getString(BundleConstants.SKYPE)%><%=request.getParameter("skype")%><br>
		<%=bundle.getString(BundleConstants.INDEX)%><%=request.getParameter("index")%><br>
		<%=bundle.getString(BundleConstants.CITY)%><%=request.getParameter("city")%><br>
		<%=bundle.getString(BundleConstants.STREET)%><%=request.getParameter("street")%><br>
		<%=bundle.getString(BundleConstants.HOUSE_NUMBER)%><%=request.getParameter("houseNumber")%><br>
		<%=bundle.getString(BundleConstants.APARTMENT_NUMBER)%><%=request.getParameter("apartmentNumber")%><br>
	</div>
	</section>
</body>
</html>