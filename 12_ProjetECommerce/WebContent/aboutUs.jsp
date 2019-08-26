<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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
			href="contactUs.jsp">Contact Us</a></li>
		<li class="nav-item"><a class="nav-link" style="color: white"
			href="aboutUs.jsp">About Us</a></li>
		<li class="nav-item"><a class="nav-link" style="color: white"
			href="${pageContext.request.contextPath}/more.jsp">More</a></li>
	</ul>
	</nav> </header>




	<div class="row">
		<div class="col-1"></div>
		<div class="col-3">
			<div class="border border-info rounded" style="height: 800px; width: 326px">
				<img class="rounded"
					src="${pageContext.request.contextPath}/resources/images/received_691782937970292.jpeg"
					alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">Audrey Arnould</h5>
					<p class="card-text">Ancienne ingénieure chimiste et aujourd'hui reconvertie 
					dans l'informatique, j'ai 29 ans et j'adore la courture, la patisserie, le dessin 
					et la fantasy/science fiction. J'aime aussi la randonnée pédestre et les voyages.</p>
				</div>
			</div>
		</div>
		<div class="col-3">
			<div class="border border-info rounded" style="height: 800px; width: 326px">
				<img class="rounded"
					src="${pageContext.request.contextPath}/resources/images/68961880_1623864364414427_4938672830838472704_n.jpg"
					alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">Emma Llor</h5>
					<p class="card-text">Docteur en astrophysique et âgée de 30 ans, je suis passionnée
					de jeux de logique, énigmes et puzzles. J'ai donc décidé de faire de ma
					passion mon travail et me reconvertissant dans l'informatique! Quel sera le prochain
					énigme à resoudre? </p>
				</div>
			</div>
		</div>
		<div class="col-3">
			<div class="border border-info rounded" style="height: 800px;width: 326px">
				<img class="rounded"
					src="${pageContext.request.contextPath}/resources/images/IMG_20190522_090004.jpg"
					alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">Romain Wasselin</h5>
					<p class="card-text">
						Anciennement diplomé d'un Master Biologie Santé en Immunologie et
						Microbiologie par l'université de Bordeaux, j'ai 25 ans et je suis
						passioné par le sport, la nature et les voyages. J'adore également
						le Hardrock/Metal et la mécanique automobile.</br>
						</br>
						<i>L'apprentissage de la vie consiste à transformer les doutes
							en certitudes.</br>- Alex Martial -
						</i>
					</p>
				</div>
			</div>
		</div>
		<div class="col-1"></div>
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