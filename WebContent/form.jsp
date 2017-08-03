<%@page import="servlet.util.BundleConstants"%>
<%@page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
             "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<%
    ResourceBundle bundle = (ResourceBundle) session.getAttribute("bundle");
%>
<title><%=bundle.getString(BundleConstants.REGISTRATION_FORM)%></title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<section class="container">
	<div class="registration">
		<h1><%=bundle.getString(BundleConstants.REGISTRATION)%></h1>
		<form method="post" action="RegistrationServlet">
			<p>
				<input type="text" name="name" value=""
					placeholder="<%=bundle.getString(BundleConstants.NAME)%>">
			</p>
			<p>
				<input type="text" name="surname" value=""
					placeholder="<%=bundle.getString(BundleConstants.SURNAME)%>">
			</p>
			<p>
				<input type="text" name="patronymic" value=""
					placeholder="<%=bundle.getString(BundleConstants.PATRONYMIC)%>">
			</p>
			<p>
				<input type="text" name="nick" value=""
					placeholder="<%=bundle.getString(BundleConstants.NICK)%>">
			</p>
			<p>
				<input type="text" name="description" value=""
					placeholder="<%=bundle.getString(BundleConstants.DESCRIPTION)%>">
			</p>
			<p>
				<input type="text" name="group" value=""
					placeholder="<%=bundle.getString(BundleConstants.GROUP)%>">
			</p>
			<p>
				<input type="text" name="mainTelephone" value=""
					placeholder="<%=bundle.getString(BundleConstants.MAIN_TELEPHONE)%>">
			</p>
			<p>
				<input type="text" name="spareTelephone" value=""
					placeholder="<%=bundle.getString(BundleConstants.SPARE_TELEPHONE)%>">
			</p>
			<p>
				<input type="text" name="email" value=""
					placeholder="<%=bundle.getString(BundleConstants.EMAIL)%>">
			</p>
			<p>
				<input type="text" name="skype" value=""
					placeholder="<%=bundle.getString(BundleConstants.SKYPE)%>">
			</p>
			<p>
				<input type="text" name="index" value=""
					placeholder="<%=bundle.getString(BundleConstants.INDEX)%>">
			</p>
			<p>
				<input type="text" name="city" value=""
					placeholder="<%=bundle.getString(BundleConstants.CITY)%>">
			</p>
			<p>
				<input type="text" name="street" value=""
					placeholder="<%=bundle.getString(BundleConstants.STREET)%>">
			</p>
			<p>
				<input type="text" name="houseNumber" value=""
					placeholder="<%=bundle.getString(BundleConstants.HOUSE_NUMBER)%>">
			</p>
			<p>
				<input type="text" name="apartmentNumber" value=""
					placeholder="<%=bundle.getString(BundleConstants.APARTMENT_NUMBER)%>">
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