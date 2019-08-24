<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Panier</title>
</head>
<body>

	<h1>Votre panier</h1>


	<table>
		<tr>
		</tr>
		<tr>
			
			<th>Article</th>
			<th>Quantité</th>
			<th>Prix des articles</th>
			<th>Supprimer du panier</th>
			

		</tr>

		<c:forEach items="${panier_attribut}" var="ligneCommande">
			<tr>
				
				<td>${ligneCommande.produit.designation}</td>
				<td>${ligneCommande.quantite}</td>
				<td>${ligneCommande.prix}</td>
				<td><a href="${pageContext.request.contextPath}/delete/panier/${ligneCommande.idLigneCommande}">Retirer du panier</a></td>
				
			</tr>
		</c:forEach>

	</table>

<br/>
	<div style="color: red">Total du panier: ${total}</div>






</body>
</html>