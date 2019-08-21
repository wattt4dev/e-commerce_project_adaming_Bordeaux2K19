<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier un user</title>
</head>
<body>

	<div>

		<h1 style="background-color: blue; color: yellow;">Modification d'un user</h1>

		<!-- formulaire -->

		<form:form modelAttribute="roleAttributeCommand" action="role/attribute"
			method="post">
			<!-- on va associer ce formulaire à notre objet de commande "fonctionnaireCommand" grace à modelAttribute -->

			<table width="100%">
				
				<tr>
					<td></td>
					<td><form:hidden path="idRole"/></td>
				</tr>
				
				<!--champs nom -->
				<tr>
					<td><form:label path="roleName">Role : </form:label></td>
					<td><form:input path="roleName" /></td>
				</tr>
				<!-- button -->
				<tr>
					<td colspan="2"><input type="submit"
						value="Modifier le role" /></td>
				</tr>

			</table>


		</form:form>



	</div>





</body>
</html>