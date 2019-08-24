<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chouquette & Co. Boutique</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet" href="resources/css/shop-homepage.css"
	type="text/css">


</head>
<body
	style="margin: 0; font-family: -apple-system, BlinkMacSystemFont, Segoe UI, Roboto, Helvetica Neue, Arial, Noto Sans, sans-serif, Apple Color Emoji, Segoe UI Emoji, Segoe UI Symbol, Noto Color Emoji; font-size: 1rem; font-weight: 400; line-height: 1.5; color: #212529; text-align: left; background-color: #fff;">
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


	</br>
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

		<div class="col-8">
			<div id="carouselExampleIndicators" class="carousel slide"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleIndicators" data-slide-to="0"
						class="active"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<a href="https://www.youtube.com/watch?v=Dw-3eaIUD-0"
							target="_blank"><img class="d-block w-100"
							src="resources/images/137876.jpg" alt="First slide" /></a>
					</div>
					<div class="carousel-item">
						<a
							href="https://www.nintendo.fr/Jeux/Nintendo-Switch/Fire-Emblem-Three-Houses-1175482.html"
							target="_blank"><img class="d-block w-100"
							src="resources/images/thumb-1920-1027448.jpg" alt="Second slide"></a>
					</div>
					<div class="carousel-item">
						<a href="https://www.youtube.com/embed/03PEoNOOsfs"
							target="_blank"><img class="d-block w-100"
							src="resources/images/783402.jpg" alt="Third slide"></a>
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleIndicators"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-3" style="margin-top: 15px; margin-left: 10px; margin-right: 10px; margin-bottom: 15px;">
			<h3 style="text-align: center; margin-bottom: 15px;"> Les briseurs de verres</h3>
			<ul class="list-unstyled">
				<li class="media"><img class="d-flex mr-3"
					src="https://mdbootstrap.com/img/Photos/Others/avatar-min1.jpg"
					alt="Generic placeholder image">
					<div class="media-body">
						<h5 class="mt-0 mb-2 font-weight-bold">Audrey</h5>
					</div></li>
				<li class="media my-4"><img class="d-flex mr-3" style="height: auto; width: 75px;"
					src="resources/images/68961880_1623864364414427_4938672830838472704_n.jpg"
					alt="Generic placeholder image">
					<div class="media-body">
						<h5 class="mt-0 mb-2 font-weight-bold">Emma</h5>
					</div></li>
				<li class="media"><img class="d-flex mr-3" style="height: auto; width: 75px;"
					src="resources/images/60981712_10217208421936869_7145118030396129280_n.jpg"
					alt="Generic placeholder image">
					<div class="media-body">
						<h5 class="mt-0 mb-2 font-weight-bold">Romain</h5>
						<h6>J'adore la nature, les voyages et le sport. J'ai 25 ans et je suis originaire de Brive-la-Gaillarde (19).</h6>
					</div></li>
			</ul>
		</div>
		<div class="container">
			<h3 align="center" style="margin-top: 5px; margin-bottom: 5px;">Tous
				les produits</h3>
			<div class="row">
				<c:forEach items="${listeProduits}" var="produit">
					<tr>
						<td>
							<div class="col-4">
								<div class="card">
									<a
										href="${pageContext.request.contextPath}/afficherArticle/{produitId}"><img
										class="card-img-top"
										src="${pageContext.request.contextPath}/resources/images/${produit.photo}"
										alt="Card image cap"></a>
									<div class="card-body">
										<h5 class="card-title">${produit.designation}</h5>
										<p class="card-text">${produit.description}</p>
										<p class="card-text">${produit.prix}euros</p>
										<p class="card-text">${produit.description}</p>
										<a
											href="${pageContext.request.contextPath}/afficherArticle/?produitId=${produit.idProduit}"
											class="btn btn-primary">Visionner l'article</a>
									</div>
								</div>
							</div>
						</td>
					</tr>
				</c:forEach>
			</div>
		</div>
	</div>

	</br>
	</br>
	</br>




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