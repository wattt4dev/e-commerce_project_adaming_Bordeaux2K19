<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenue</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/adminProduit/liste_produits">AdminProduit</a>
<a href="${pageContext.request.contextPath}/adminCategorie/welcomeAdminCategorie">AdminCategorie</a>


	Accueil Internaute 

<div style="background-color: blue">
Liste des Catégories :
<table>
	<c:forEach items="${listeCategorie}" var="cat">
		<tr>
		<td><a href="${pageContext.request.contextPath}/recherche/catégorie/${cat.idCategorie}">${cat.nomCategorie}</a></td>
		</tr>
	
	</c:forEach>

</table>
</div>

<a href="${pageContext.request.contextPath}/advancedresearch">Rechercher un article par mot-clé</a>



<a href="${pageContext.request.contextPath}/afficher/panier"> Voir mon panier</a>
</body>
</html>