<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Résultat de votre recherche avancée</title>
</head>
<body>

<div>
<h3> Rechercher un produit par mot-clé</h3>
	<form  action="recherche" method="get">
		<input type="text" value="${mc}" name="mc" />
		<input type="submit" value="Rechercher">
	
	</form>
</div>


<h1> Résultats de votre recherche</h1>


<table>
			
		<c:forEach items="${listeProduitMotCle}" var="produit">
		<tr>
			<td><img src="${pageContext.request.contextPath}/resources/${produit.photo}"></td>
			<td><a href="${pageContext.request.contextPath}/afficherArticle/${produit.idProduit}"><b>${produit.designation}</b></a>
			<br/>
			${produit.description}
				<a >Ajouter au panier</a>
			</td>
		</tr>
		</c:forEach>
	</table>


</body>
</html>