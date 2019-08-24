<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<!-- spring mvc possede ses propres taglib form -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout d'un produit</title>
</head>
<body>



	<div align="center">
		<h1>Ajout d'un nouveau produit</h1>
		<!-- formulaire -->

		<form:form modelAttribute="produitCommande" 
			action="produit/add" method="post">
			<table>
				<tr>
					<td></td>
					<td><form:hidden path="idProduit"/> </td>
				</tr>
			
				<tr>
					<td><form:label path="designation">D�signation</form:label></td>
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
					<td><form:label path="quantite">Quantit�</form:label></td>
					<td><form:input path="quantite" /></td>
				</tr>
				
				<tr>
					<td><form:label path="photo">Photo</form:label></td>
					<td><form:input path="photo"/></td>
				</tr>
				
				
				<tr>
					<td>Categorie</td>
					<td><form:select  path="idCat" >
					<form:option value="-" label="-Choisir une categorie-"/>
					<form:options items="${ attribut_categories }" itemLabel="nomCategorie" itemValue="idCategorie"/>
					</form:select>
					</td>
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