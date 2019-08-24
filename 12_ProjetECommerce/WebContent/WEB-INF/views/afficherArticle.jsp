<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Article</title>
</head>
<body>



<div>
<h2>${produitDesignation}</h2>
<h6 style="text-align: right;">${produitCategorie}</h6>
<br/>

<img src="${pageContext.request.contextPath}/resources/images/${produitPhoto}">


${produitDescription}


<h5>${produitPrix}</h5>

<h6>${ProduitQuantite}</h6>
<a>Ajouter au panier</a>







</div>








</body>
</html>