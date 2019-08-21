<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulaire d'ajout User</title>
</head>
<body>

	<div>

		<h1 style="background-color: blue; color: yellow;">Ajout d'un
			nouvel user</h1>

		<!-- formulaire -->

		<form:form modelAttribute="userCommand" action="user/add"
			method="post">
			<!-- on va associer ce formulaire à notre objet de commande "fonctionnaireCommand" grace à modelAttribute -->

			<table width="100%">

				<!--champs nom -->
				<tr>
					<td><form:label path="userName">Username : </form:label></td>
					<td><form:input path="userName" /></td>
				</tr>

				<!--champs fonction -->
				<tr>
					<td><form:label path="password">Password : </form:label></td>
					<td><form:input path="password" /></td>
				</tr>

				<!--champs salaire -->
				<tr>
					<td><form:label path="actived">Activation : </form:label></td>
					<td><form:input path="actived" /></td>
				</tr>

				<!-- button -->
				<tr>
					<td colspan="2"><input type="submit"
						value="Ajouter un User" /></td>
				</tr>

			</table>


		</form:form>



	</div>


</body>
</html>