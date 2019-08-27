<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
			href="${pageContext.request.contextPath}/panier/getProduits">Panier
		</a></li>
	</ul>
	</nav> </header>

	<c:url value="login" var="loginUrl" />




	<div class="container">
		<div class="row">
			<div class="col-md-5 mx-auto">
				<div id="first">
					<div class="myform form ">
						<div class="logo mb-3">
							<div class="col-md-12 text-center">
								<h1>Login</h1>
							</div>
						</div>
						<form action="${loginUrl}" method="post" name="login">
							<div class="form-group">
								<tr>
									<td>Username</td>
									<td><input type="text" name="username"
										class="form-control" placeholder="Username" /></td>
								</tr>
							</div>
							<div class="form-group">
								<tr>
									<td>Password</td>
									<td><input type="password" name="password"
										class="form-control" placeholder="Password" /></td>
								</tr>
							</div>

							<div class="col-md-12 text-center ">
								<button type="submit"
									class=" btn btn-block mybtn btn-primary tx-tfm">Login</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>



	<div class="list-group-item bg-light" align="center"
		style="margin-top: 20px; margin-bottom: 20px; margin-right: 20px; margin-left: 20px; border-radius: 5px;">

		<h1 style="margin-top: 20px; margin-bottom: 20px;">S'enregister</h1>

		<!-- formulaire -->
		<div align="center">
			<form:form modelAttribute="clientCommand" action="addClient/add"
				method="post">
				<!-- on va associer ce formulaire à notre objet de commande "fonctionnaireCommand" grace à modelAttribute -->

				<table width="100%">

					<!--champs nom -->
					<tr>
						<td><form:label path="nomClient">Nom : </form:label></td>
						<td><form:input path="nomClient" /></td>
					</tr>

					<!--champs fonction -->
					<tr>
						<td><form:label path="adresse">Adresse : </form:label></td>
						<td><form:input path="adresse" /></td>
					</tr>

					<!--champs salaire -->
					<tr>
						<td><form:label path="mail">Mail : </form:label></td>
						<td><form:input path="mail" /></td>
					</tr>

					<tr>
						<td><form:label path="username">Username : </form:label></td>
						<td><form:input path="username" /></td>
					</tr>

					<tr>
						<td><form:label path="password">Password : </form:label></td>
						<td><form:password path="password" /></td>
						
					</tr>



					<!-- button -->
					<tr>
						<td colspan="2"><input type="submit" class="btn btn-primary"
							value="S'enregistrer" /></td>
					</tr>

				</table>


			</form:form>
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