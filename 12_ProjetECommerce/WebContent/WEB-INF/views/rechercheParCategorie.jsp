<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recherche de produits par catégorie</title>
</head>
<body>

Accueil rechercher par Catégorie

<div style="color: red; background-color: gray">

<h1>${categorie.nomCategorie}</h1>

<h3>${categorie.description}</h3>
<img src="${pageContext.request.contextPath}/resources/${categorie.photo}">


</div>


<div>



	<table>
			
		<c:forEach items="${listeProduitCategorie}" var="produit">
		<tr>
			
			<td><img src="${pageContext.request.contextPath}/resources/${produit.photo}"></td>
			
			<td><a href="${pageContext.request.contextPath}/afficherArticle/${produit.idProduit}"><b>${produit.designation}</b></a>
			<td>
			${produit.description}</td>
				<td><a >Ajouter au panier</a></td>
		</tr>
		</c:forEach>
	</table>





</div>









</body>
</html>