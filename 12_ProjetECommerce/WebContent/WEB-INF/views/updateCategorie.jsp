<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier une catégorie</title>
</head>
<body>

	<div>

		<h1 style="background-color: blue; color: yellow;">Modification d'une catégorie</h1>

		<!-- formulaire -->

		<form:form modelAttribute="categorieCommandUpdate" action="categorie/update"
			method="post">
			<!-- on va associer ce formulaire à notre objet de commande "fonctionnaireCommand" grace à modelAttribute -->

			<table width="100%">
				
				<tr>
					<td></td>
					<td><form:hidden path="idCategorie"/></td>
				</tr>
				
				<!--champs nom -->
				<tr>
					<td><form:label path="nomCategorie">Nom de la Categorie : </form:label></td>
					<td><form:input path="nomCategorie" /></td>
				</tr>

				<!--champs fonction -->
				<tr>
					<td><form:label path="description">Description de la catégorie : </form:label></td>
					<td><form:input path="description" /></td>
				</tr>

				<!--champs salaire -->
				<tr>
					<td><form:label path="photo">Photo : </form:label></td>
					<td><form:input path="photo" /></td>
				</tr>

				<!-- button -->
				<tr>
					<td colspan="2"><input type="submit"
						value="Modifier la catégorie" /></td>
				</tr>

			</table>


		</form:form>



	</div>





</body>
</html>