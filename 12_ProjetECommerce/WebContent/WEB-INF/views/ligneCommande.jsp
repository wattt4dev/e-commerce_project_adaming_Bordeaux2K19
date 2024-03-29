<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout au panier</title>

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



	<div class="row">
		<div class="col-8">
			<div align="center" class="border border-info rounded"
				style="height: 400px; margin-top: 10px; width: auto; margin-left: 10px;">
				<div class="row">
					<div class="col" align="center">
						<img class="card-img-top img-fluid"
							style="height: 300px; width: auto; margin-top: 5px;"
							src="${produit.picture}"
							alt="photo">
					</div>
					<div class="col">
						<div class="card-body">
							<h3 class="card-title">${produit.designation}</h3>
							<h4>Prix unitaire : ${produit.prix} euros</h4>
							<p class="card-text">${produit.description}</p>


						</div>
					</div>
				</div>
			</div>

		</div>


		<div class="col-4">
			<div class="border border-info rounded" style="margin-top: 10px; margin-left: 50px;">

			
				<form:form modelAttribute="ligneCommande"
					action="${pageContext.request.contextPath}/panier/ajouterPanier"
					method="post">
					<table>
						<tr>
							<td></td>
							<td><form:hidden path="idLigneCommande" /></td>
						</tr>

						<tr>
							<td></td>
							<td><form:hidden path="idP" /></td>
						</tr>

						<tr>
							<td><form:label path="produit.designation" /></td>
						</tr>

						<tr>
							<td><form:label path="quantite">Quantite voulue</form:label></td>
							<td><form:input path="quantite" /></td>
						</tr>

						<tr>
							<td><div align="center"><input type="submit" class="btn btn-primary" value="Ajouter au panier" /></div></td>
						</tr>
					</table>
				</form:form>

			</div>
		</div>



	</div>
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