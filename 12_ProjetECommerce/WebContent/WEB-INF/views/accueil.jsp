<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil Admin Categorie</title>
</head>
<body>

	<h1 style="background-color: yellow; color: blue; text-align: center;">
		${attribut_titre}</h1>


	<!-- recup du message renvoyé par le controller-->
	<h2 style="background-color: red; color: black; text-align: center;">
		${attribut_message}</h2>


	<!-- recup de la date renvoyée par le controller-->
	<h3 style="background-color: green; color: blac; text-align: center;">
		Nous sommes le :
		<fmt:formatDate value="${attribut_date}" pattern="dd-MM-yyyy" />
		<br /> il est :
		<fmt:formatDate value="${attribut_date}" type="time" timeStyle="short" />
	</h3>


</body>
</html>