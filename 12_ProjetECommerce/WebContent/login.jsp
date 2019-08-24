<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

	<!-- Affichage des erreurs après echec authentification -->
		<!-- Recupération du paramètre erreur -->
	<c:if test="${ not empty param.error }">
		<font>
			Login error <br/>
			Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</font>
	</c:if>
	
	<!-- Affichage du message de deconnexion-->
	<c:if test="${not empty param.logout_message}">
		<font>
			You have succesfully log out
		</font>
	</c:if>

	<!-- Construction de l'url d'authentification à la soumission -->
	<c:url value="login" var="loginUrl"/>
	
	<!-- Formulaire -->
	
	<form action="${loginUrl}" method="post">
		<table>
			<tr>
				<td>Username : </td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>Password : </td>
				<td><input type="text" name="password"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="Connection"/> | <input type="reset" value="Reset"/></td>
			</tr>
		</table>
	</form>
	

</body>
</html>