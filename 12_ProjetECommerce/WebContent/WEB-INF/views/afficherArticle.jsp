<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Article</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet" href="resources/css/shop-homepage.css"
	type="text/css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/shop-item.css" rel="stylesheet">
</head>
<body>

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
			href="contactUs.jsp">Contact Us</a></li>
		<li class="nav-item"><a class="nav-link" style="color: white"
			href="aboutUs.jsp">About Us</a></li>
		<li class="nav-item"><a class="nav-link" style="color: white"
			href="${pageContext.request.contextPath}/panier/getProduits">Panier</a></li>
			<li class="nav-item"><a class="nav-link" style="color: white"
			href="${pageContext.request.contextPath}/logout"><img alt="" style="height: 20px; width: auto;" src="resources/images/disconnect-icon-png-10.png">
		</a></li>
	</ul>
	</nav> </header>
	<br />

	<div class="row">
		<div class="col-3" id="categories">

			<h3 class="list-group-item" style="border-radius: 3px;">Catégories</h3>
			<div class="list-group">
				<table>
					<c:forEach items="${listeCategorie}" var="cat">
						<tr>
							<td><a class="list-group-item bg-light"
								href="${pageContext.request.contextPath}/recherche/catégorie/${cat.idCategorie}">${cat.nomCategorie}</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

		<div align="center" class="col-lg-9">

			<div align="center" class="border border-info rounded" style="height: 800px; width: 450px;">
				<img class="card-img-top img-fluid"
					style="height: 300px; width: auto; margin-top: 5px;"
					src="${produit.picture}"
					alt="">
				<div class="card-body">
					<h3 class="card-title">${produit.designation}</h3>
					<h4>Prix unitaire : ${produit.prix} euros</h4>
					<p class="card-text">${produit.description}</p>
					<a class="btn btn-primary"
						href="${pageContext.request.contextPath}/panier/addProduit/${produit.idProduit}">Ajouter
						au panier</a>


				</div>
			</div>
		</div>
	</div>

	<!-- /.container -->

	<br />
	<br />
	<br />


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


	<!-- Bootstrap core JavaScript -->
	<script src="resources/css/jquery.min.js"></script>
	<script src="resources/css/bootstrap.bundle.min.js"></script>

</body>
</html>