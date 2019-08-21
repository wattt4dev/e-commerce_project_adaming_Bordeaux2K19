<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>liste_produits</title>
</head>
<body>

<div align="center">
		<h1>Liste des Produits</h1>


		<table>
			<tr>
				<td colspan="4">
					<a href="${pageContext.request.contextPath}/adminProduit/addProduit" style="background-color: lightblue">Ajouter un produit</a>
				</td>
			</tr>
			<tr>
				<th>Identifiant</th>
				<th>Désignation</th>
				<th>Déscription</th>
				<th>Prix</th>
				<th>Quantité</th>
			</tr>

			<c:forEach items="${att_listeProduits}"
				var="produit">

				<tr>
					<td>${produit.idProduit}</td>
					<td>${produit.designation}</td>
					<td>${produit.description}</td>
					<td>${produit.prix}</td>
					<td>${produit.quantite}</td>

					<td><a href="${pageContext.request.contextPath}/adminCategorie/produit/delete/${produit.idProduit}">Supprimer</a></td>
				</tr>

			</c:forEach>


		</table>




	</div>



</body>
</html>