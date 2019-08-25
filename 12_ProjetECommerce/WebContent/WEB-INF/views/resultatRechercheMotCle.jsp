<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Résultat de votre recherche avancée</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">




</head>
<body style="height: 100%">

	<header> <nav class="py-5 bg-dark">
	<ul class="nav justify-content-end">
		<li class="nav-item"><a class="nav-link"
			style="color: white; position: absolute; left: 10px"
			href="${pageContext.request.contextPath}/accueilBoutique">Chouquette
				& Co. Boutique</a></li>
		<li class="nav-item"><a class="nav-link active"
			style="color: white;"
			href="${pageContext.request.contextPath}/accueilBoutique">Home</a></li>
		<li class="nav-item"><a class="nav-link" style="color: white"
			href="#">Contact Us</a></li>
		<li class="nav-item"><a class="nav-link" style="color: white"
			href="aboutUs.jsp">About Us</a></li>
		<li class="nav-item"><a class="nav-link" style="color: white"
			href="#">More</a></li>
	</ul>
	</nav> </header>


	<div class="row">
		<div class="col" align="center"
			style="margin-top: 25px; margin-bottom: 25px;">
			<h3>Rechercher un produit</h3>
			<form action="recherche" method="get">
				<input type="text" value="${mc}" name="mc" /> <input type="submit"
					value="Rechercher">
			</form>
		</div>
	</div>

	<div class="row">
		<div class="col" align="center">
			<h3>Résultats de votre recherche</h3>
			<table>
				<c:forEach items="${listeProduitMotCle}" var="produit">
					<tr>
						<td>
							<img
									src="${pageContext.request.contextPath}/resources/images/${produit.photo}">
						</td>
					</tr>
					<tr>
						<td>Nom : </td>
						<td><a href="${pageContext.request.contextPath}/afficherArticle/${produit.idProduit}"><b>${produit.designation}</b></a>
					</tr>
					<tr>
						<td>Description : </td>
						<td>${produit.description}</td>
					<tr>
						<td>Prix unitaire : </td>
						<td>${produit.prix}</td>
					</tr>
					<tr>
						<td>Quantité en stock : </td>
						<td>${produit.quantite}</td>
					</tr>
					<tr>
						<td><a href="${pageContext.request.contextPath}/ligneCommande?produitId=${produit.idProduit}">Ajouter au panier</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>


	<!-- Footer -->
	<footer class="py-5 bg-dark">
	<div class="container" align="center">
		<p class="m-0 text-center text-white">
			Copyright &copy; Chouquette & Co. 2019</br> <a
				href="${pageContext.request.contextPath}/adminCategorie/welcomeAdminCategorie">Accueil
				Administrateur Catégorie</a></br> <a
				href="${pageContext.request.contextPath}/adminProduit/liste_produits">Accueil
				Administrateur Produit</a>
		</p>
	</div>
	</footer>



	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>





</body>
</html>