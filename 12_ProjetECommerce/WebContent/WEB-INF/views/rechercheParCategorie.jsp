<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recherche de produits par catégorie</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>
<body>


	<header> <nav class="py-5 bg-dark">
	<ul class="nav justify-content-end">
		<li class="nav-item"><a class="nav-link"
			style="color: white; position: absolute; left: 10px"
			href="accueilBoutique.jsp">Chouquette & Co. Boutique</a></li>
		<li class="nav-item"><a class="nav-link active"
			style="color: white;" href="accueilBoutique.jsp">Home</a></li>
		<li class="nav-item"><a class="nav-link" style="color: white"
			href="#">Contact Us</a></li>
		<li class="nav-item"><a class="nav-link" style="color: white"
			href="#">About Us</a></li>
		<li class="nav-item"><a class="nav-link" style="color: white"
			href="${pageContext.request.contextPath}/panier/getProduits">Panier </a> </li>
	</ul>
	</nav> </header>


	<div class="row" style="border-bottom-color: lightgrey; border: solid;">
		<div align="center" class="col">

			<h1>${categorie.nomCategorie}</h1>

			<h3>${categorie.description}</h3>
			<img style="height: 200px; width: auto;"
				src="${pageContext.request.contextPath}/resources/images/${categorie.photo}">


		</div>
	</div>

	<div class="row">
	<div align="center" class="col">



	<table>
			
		<c:forEach items="${listeProduitCategorie}" var="produit">
		<tr>
			
			<td><img style="height: 200px" src="${pageContext.request.contextPath}/resources/${produit.photo}"></td>
			
			<td><a href="${pageContext.request.contextPath}/afficherArticle/${produit.idProduit}"><b>${produit.designation}</b></a>
			<td>
			${produit.description}</td>
				<td><a href="${pageContext.request.contextPath}/panier/addProduit/${produit.idProduit}" >Ajouter au panier</a></td>
		</tr>
		</c:forEach>
	</table>






	</div>
	</div>

	<!-- Footer -->
	<footer class="py-5 bg-dark">
	<div class="container">
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