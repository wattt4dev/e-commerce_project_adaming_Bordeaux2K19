<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil Admin Categorie</title>

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
			href="accueilBoutique.jsp">Chouquette & Co. Boutique</a></li>

		<li class="nav-item"><a class="nav-link active" style="color: red;">${attribut_message}</a></li>
		<li class="nav-item"><a class="nav-link active" style="color: white;"><fmt:formatDate value="${attribut_date}"
					pattern="dd-MM-yyyy" /> | <fmt:formatDate value="${attribut_date}"
					type="time" timeStyle="short" /></a></li>


		<li class="nav-item"><a class="nav-link active"
			style="color: white;" href="accueilBoutique.jsp">Home</a></li>

		<li class="nav-item"><a class="nav-link" style="color: white"
			href="#">Contact Us</a></li>

		<li class="nav-item"><a class="nav-link" style="color: white"
			href="#">About Us</a></li>

		<li class="nav-item"><a class="nav-link" style="color: white"
			href="#">More</a></li>
	</ul>
	</nav> </header>

	


	<div class="row">
		<div class="col" align="center">

			<h1>Liste des catégories</h1>



			<!-- lein pour ajout du fonctionnaire -->

			<a
				href="${pageContext.request.contextPath}/adminCategorie/addCategorie">Ajouter
				une catégorie</a>

			<table class="table">
				<thead class="thead bg-dark">
					<tr>
						<th scope="col" class="column">#ID Catégorie</th>
						<th scope="col" class="column">Nom Catégorie</th>
						<th scope="col" class="column">Description Catégorie</th>
						<th scope="col" class="column">Photo</th>
						<th scope="col" class="column">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${attribut_categories}" var="categorie">

						<tr class="bg-light">
							<td><b>${categorie.idCategorie}</b></td>
							<td>${categorie.nomCategorie}</td>
							<td>${categorie.description}</td>
							<td>${categorie.photo}</td>
							<td><a
								href="${pageContext.request.contextPath}/adminCategorie/updateCategorie?idCategorie=${categorie.idCategorie}">Modifier</a>
								<a
								href="${pageContext.request.contextPath}/adminCategorie/categorie/delete/${categorie.idCategorie}">Supprimer</a>
							</td>
						</tr>

					</c:forEach>
				</tbody>
			</table>


		</div>
	</div>

	<div class="row">
		<div class="col" align="center">
			<h1>Liste des users</h1>
			<a href="${pageContext.request.contextPath}/adminCategorie/addUser">Ajouter
				un user</a>
			<table class="table">
				<thead class="thead bg-dark">
					<tr>
						<th scope="col" class="column">#ID User</th>
						<th scope="col" class="column">Username</th>
						<th scope="col" class="column">Password</th>
						<th scope="col" class="column">Activation</th>
						<th scope="col" class="column">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${attribut_users}" var="user">

						<tr class="bg-light">
							<td><b>${user.idUser}</b></td>
							<td>${user.userName}</td>
							<td>${user.password}</td>
							<td>${user.actived}</td>
							<td><a
								href="${pageContext.request.contextPath}/adminCategorie/updateUser?idUser=${user.idUser}">Modifier
									| </a> <a
								href="${pageContext.request.contextPath}/adminCategorie/attribuerRole?idUser=${user.idUser}">Attribuer
									Role | </a> <a
								href="${pageContext.request.contextPath}/adminCategorie/user/delete/${user.idUser}">Supprimer</a>
							</td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div class="row">
		<div class="col" align="center">

			<h1>Liste des roles</h1>

			<table class="table">
				<thead class="thead bg-dark">
					<tr>
						<th scope="col" class="column">#ID Role</th>
						<th scope="col" class="column">Role</th>
						<th scope="col" class="column">#ID User</th>
						<th scope="col" class="column">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${attribut_roles}" var="role">

						<tr class="bg-light">
							<td><b>${role.idRole}</b></td>
							<td>${role.roleName}</td>
							<td>${user.idUser}</td>
							<td><a
								href="${pageContext.request.contextPath}/adminCategorie/updateUser?idUser=${user.idUser}">Modifier
									| </a> <a
								href="${pageContext.request.contextPath}/adminCategorie/attribuerRole?idUser=${user.idUser}">Attribuer
									User | </a> <a
								href="${pageContext.request.contextPath}/adminCategorie/user/delete/${user.idUser}">Supprimer</a>
							</td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	</br>
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