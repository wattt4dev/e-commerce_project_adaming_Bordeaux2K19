<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulaire Ajout Categorie</title>
</head>
<body>

	<div>

		<h1 style="background-color: blue; color: yellow;">Ajout d'une
			nouvelle cat�gorie</h1>

		<!-- formulaire -->

		<form:form modelAttribute="categorieCommand"
			action="categorie/add" method="post">
			<!-- on va associer ce formulaire � notre objet de commande "fonctionnaireCommand" grace � modelAttribute -->

			<table width="100%">

				<!--champs nom -->
				<tr>
					<td><form:label path="nomCategorie">Nom de la Categorie : </form:label></td>
					<td><form:input path="nomCategorie" /></td>
				</tr>

				<!--champs fonction -->
				<tr>
					<td><form:label path="description">Description de la cat�gorie : </form:label></td>
					<td><form:input path="description" /></td>
				</tr>

				<!--champs salaire -->
				<tr>
					<td><form:label path="photo">Photo : </form:label></td>
					<td><form:input path="photo" /></td>
				</tr>

				<!-- button -->
				<tr>
					<td colspan="2"><input type="submit" value="Ajouter une cat�gorie" /></td>
				</tr>

			</table>


		</form:form>



	</div>



</body>
</html>