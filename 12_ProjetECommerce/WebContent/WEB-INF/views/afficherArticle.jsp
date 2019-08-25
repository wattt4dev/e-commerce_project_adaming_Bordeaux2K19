<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Article</title>
</head>
<body>



<div>
<h2>${produit.designation}</h2>
<h6 style="text-align: right;">${produit.categorie}</h6>
<br/>

<img src="${pageContext.request.contextPath}/resources/images/${produitPhoto}">



${produit.description}


<h5>${produit.prix}</h5>



<h6>${produit.quantite}</h6>
<a href="${pageContext.request.contextPath}/ligneCommande?produitId=${produit.idProduit}">Ajouter au panier</a>









</div>








</body>
</html>