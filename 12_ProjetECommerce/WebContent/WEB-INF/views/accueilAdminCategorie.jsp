<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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

	<div align="center">

		<h1 style="background-color: blue; color: yellow;">Liste des
			catégories</h1>

		<table cellspacing="0" cellpadding="6" width="60%">

			<!-- lein pour ajout du fonctionnaire -->
			<tr>
				<td colspan="4" align="right"><a
					href="${pageContext.request.contextPath}/adminCategorie/addCategorie"
					style="background-color: lightblue">Ajouter une catégorie</a></td>
			</tr>


			<!-- affichage de la liste des fonctionnaire -->
			<tr bgcolor="grey" style="color: white">
				<th>#ID Catégorie</th>
				<th>Nom Catégorie</th>
				<th>Description Catégorie</th>
				<th>Photo</th>
				<th>Actions</th>

				<c:forEach items="${attribut_categories}" var="categorie">

					<tr bgcolor="lightyellow">
						<td><b>${categorie.idCategorie}</b></td>
						<td>${categorie.nomCategorie}</td>
						<td>${categorie.description}</td>
						<td>${categorie.photo}</td>
						<td><a
							href="${pageContext.request.contextPath}/adminCategorie/updateCategorie?idCategorie=${categorie.idCategorie}">Modifier</a>
							<a
							href="${pageContext.request.contextPath}/adminCategorie/categorie/delete/${categorie.idCategorie}">Supprimer</a>
						</td>
					</tr>

				</c:forEach>
		</table>
	</div>
	
</body>
</html>