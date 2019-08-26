<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Panier</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet" href="resources/css/shop-homepage.css"
	type="text/css">
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
			href="#">Contact Us</a></li>
		<li class="nav-item"><a class="nav-link" style="color: white"
			href="aboutUs.jsp">About Us</a></li>
		<li class="nav-item"><a class="nav-link" style="color: white"
			href="${pageContext.request.contextPath}/panier/getProduits">Panier
		</a>></li>
	</ul>
	</nav> </header>


	<div class="row">
		<div class="col-8">
			<div class="card mt-4" style="background-color: lightgray">

				<h1>Votre panier</h1>


				<table>
					<tr>
					</tr>
					<tr>

						<th>Article</th>
						<th>Cat�gorie</th>
						<th>Quantit�</th>
						<th>Prix des articles</th>
						<th>Supprimer du panier</th>


					</tr>

					<c:forEach items="${panier_attribut}" var="ligneCommande">
						<tr>

							<td>${ligneCommande.produit.designation}</td>
							<td>${ligneCommande.produit.categorie.nomCategorie}</td>
							<td>${ligneCommande.quantite}</td>
							<td>${ligneCommande.prix}</td>
							<td><a
								href="${pageContext.request.contextPath}/panier/suppProduit/${ligneCommande.idLigneCommande}">Retirer
									du panier</a></td>

						</tr>
					</c:forEach>

				</table>

			</div>
		</div>

		<div class="col-4">
			<div class="card mt-4" style="border-color: gray">


				<br />
				<div style="color: red">
					<h3>Total du panier: ${total}</h3>
				</div>


				<div>
					<a class="list-group-item bg-light"
						href="${pageContext.request.contextPath}/accueilBoutique">Poursuivre
						mes achats </a>
				</div>

				<div>
					<a class="list-group-item bg-light"
						href="${pageContext.request.contextPath}/addPanier/${panier_attribut}">Valider
						votre commande </a>
				</div>


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
				Administrateur Cat�gorie</a></br> <a
				href="${pageContext.request.contextPath}/adminProduit/liste_produits">Accueil
				Administrateur Produit</a>
		</p>
	</div>
	</footer>




	<!-- Bootstrap core JavaScript -->
	<script src="resources/css/jquery.min.js"></script>
	<script src="resources/css/bootstrap.bundle.min.js"></script>
</body>
</html>