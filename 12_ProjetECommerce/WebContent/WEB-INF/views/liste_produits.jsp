<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil Admin Produit</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="http://localhost:8080/12_ProjetECommerce/resources/css/homepage-admin.css"
	type="text/css">

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


</head>
<body>

		<header> <nav class="py-5 bg-dark">
	<ul class="nav justify-content-end">
		<li class="nav-item"><a class="nav-link"
			style="color: white; position: absolute; left: 10px"
			href="${pageContext.request.contextPath}/accueilBoutique">Chouquette & Co. Boutique</a></li>

		<li class="nav-item"><a class="nav-link active" style="color: red;">${attribut_message}</a></li>
		<li class="nav-item"><a class="nav-link active" style="color: white;"><fmt:formatDate value="${attribut_date}"
					pattern="dd-MM-yyyy" /> | <fmt:formatDate value="${attribut_date}"
					type="time" timeStyle="short" /></a></li>


		<li class="nav-item"><a class="nav-link active"
			style="color: white;" href="accueilBoutique.jsp">Home</a></li>

		<li class="nav-item"><a class="nav-link" style="color: white"
			href="contactUs.jsp">Contact Us</a></li>

		<li class="nav-item"><a class="nav-link" style="color: white"
			href="aboutUs.jsp">About Us</a></li>

		<li class="nav-item"><a class="nav-link" style="color: white"
			href="more.jsp">More</a></li>
	</ul>
	</nav> </header>


		<div class="row">
			<div class="col" align="center">

				<h1>Liste des Produits</h1>
				<a href="${pageContext.request.contextPath}/adminProduit/addProduit">Ajouter
					un produit</a>
				<table class="table">
					<thead class="thead bg-dark">
						<tr>
							<th class="column">Identifiant</th>
							<th class="column">Désignation</th>
							<th class="column">Déscription</th>
							<th class="column">Prix</th>
							<th class="column">Quantité</th>
							<th class="column">Photo</th>
							<th class="column">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${att_listeProduits}" var="produit">
							<tr class="bg-light">
								<td>${produit.idProduit}</td>
								<td>${produit.designation}</td>
								<td>${produit.description}</td>
								<td>${produit.prix}</td>
								<td>${produit.quantite}</td>
								<td><img style="height: 100px; width: auto;" src="${produit.picture}"/></td>
								<td><a
									href="${pageContext.request.contextPath}/adminProduit/produit/delete/${produit.idProduit}">Supprimer</a>
								<a
									href="${pageContext.request.contextPath}/adminProduit/produit/updateform?produitId=${produit.idProduit}">
										Modifier</a></td>
							</tr>
						</c:forEach>
					</tbody>
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
</body>
</html>