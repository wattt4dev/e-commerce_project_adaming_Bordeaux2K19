<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Wrong way !!</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="http://localhost:8080/12_ProjetECommerce/resources/css/login.css"
	type="text/css">

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<!------ Include the above in your HEAD tag ---------->

<link href="https://fonts.googleapis.com/css?family=Kaushan+Script"
	rel="stylesheet">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">

</head>
<body
	style="background-color: black; background-repeat: no-repeat; background-position: center; background-size: contain; width: 100%; height: 100%; background-image: url('resources/images/pokemon__snorlax___you_shall_not_pass__by_scotlette-d8z2bth.png');">


	<c:url value="login" var="loginUrl" />

	<div class="col" align="center">
		<h2><a href="${pageContext.request.contextPath}/accueilBoutique" style="color: white;">Maison du Hobbit</a></h2>
	</div>
	<div class="row">

		<div class="col"
			style="margin-left: 75px; margin-top: 200px; margin-right: 0px; width: 500px">
			<div class="row">
				<div>
					<div id="first">
						<div class="myform form" style="color: white;">
							<div class="logo mb-3">
								<div class="text-center">
									<a href="login.jsp"><h1 style="color: white;">Login</h1></a>
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

								<div class="text-center">
									<button type="submit" class=" btn btn-block btn-primary tx-tfm">Login</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2"></div>
		<div class="col" align="left"
			style="margin-top: 150px; margin-right: 0px; margin-left:460px; width: 500px">
			<div class="row">
				<div>
					<div id="first">
						<div class="myform form" style="color: white;">
							<div class="logo mb-3">
								<div class="text-center">
									<h1>
										<a href="login.jsp" style="color: white;">Register</a>
									</h1>
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
								<div class="form-group">
									<tr>
										<td>Password Confirmation</td>
										<td><input type="password" name="password"
											class="form-control" placeholder="Confirmation password" /></td>
									</tr>
								</div>
								<div class="form-group">
									<tr>
										<td>Mail</td>
										<td><input type="text" name="mail"
											class="form-control" placeholder="exemple@exemple.com" /></td>
									</tr>
								</div>
								
								<div class="text-center">
									<button type="submit" class=" btn btn-block btn-primary tx-tfm">Login</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>