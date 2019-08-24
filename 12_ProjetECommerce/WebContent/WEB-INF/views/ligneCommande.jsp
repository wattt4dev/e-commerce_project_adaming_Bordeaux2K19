<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout au panier</title>
</head>
<body>


	panier intermédiaire
	<div>

		<form:form  modelAttribute="ligneCommande" action="${pageContext.request.contextPath}/ajouterPanier" method="post">
			<table>
				<tr>
					<td></td>
					<td><form:hidden path="idLigneCommande"/></td>
				</tr>
				
				<tr>
					<td></td>
					<td><form:hidden path="idP"/></td>
				</tr>
				
				<tr>
					<td><form:label path="produit.designation"/></td>
				</tr>

				<tr>
					<td>
					<form:label path="quantite">Quantite</form:label></td>
					<td><form:input path="quantite"/></td>
					</tr>
					
				<tr>
					<td><input type="submit" value="Ajouter"/></td>
				</tr>
			</table>
		</form:form>


	</div>








</body>
</html>