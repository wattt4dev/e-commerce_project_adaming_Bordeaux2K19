<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<!-- spring mvc possede ses propres taglib form -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout d'un produit</title>
</head>
<body>



	<div align="center">
		<h1>Ajout d'un nouveau produti</h1>
		<!-- formulaire -->

		<form:form modelAttribute="produitCommande"
			action="/produit/add" method="post">
			<table>
				<tr>
					<td><form:label path="designation">Désignation</form:label></td>
					<td><form:input path="designation" /></td>
				</tr>

				<tr>
					<td><form:label path="description">Description</form:label></td>
					<td><form:input path="description" /></td>
				</tr>

				<tr>
					<td><form:label path="prix">Prix</form:label></td>
					<td><form:input path="prix" /></td>
				</tr>
				
				<tr>
					<td><form:label path="quantite">Quantité</form:label></td>
					<td><form:input path="quantite" /></td>
				</tr>


				<!-- bouton -->
				<tr>

					<td colspan="2"><input type="submit" value="Ajouter" /></td>
				</tr>


			</table>



		</form:form>




	</div>





</body>
</html>