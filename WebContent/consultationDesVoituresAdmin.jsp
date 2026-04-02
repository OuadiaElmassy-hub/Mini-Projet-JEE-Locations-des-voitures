<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Page de consultation pour l'Admin </title>
    <!-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">-->
	<style>
	</style>
</head>
<body>
	<div>
		<!-- formulaire de recherche des voitures on se basant sur date de reservation et categories -->
	</div>
	<hr />
	<div>
		<a href="formAjouterVoiture.do">Ajouter voiture</a>
	</div><br><br>
	<div>
		<!-- Affichage des voitures tous ou apres une recherche -->
		<table>
			<tr>
				<th>IdVoiture</th>
				<th>Matricule</th>
				<th>Marque</th>
				<th>Modele</th>
				<th>Categorie</th>
				<th>PrixJour</th>
				<th>Image</th>
				<th colspan="2">Action</th>
			</tr>
			<c:forEach var="v" items="${voitures }">
				<tr>
					<td>${v.idVoiture }</td>
					<td>${v.matricule }</td>
					<td>${v.marque }</td>
					<td>${v.modele }</td>
					<td>${v.categorie }</td>
					<td>${v.prixJour }</td>
					<td>${v.image }</td>
					<td><a href="formModifierVoiture.do?idVoiture=${v.idVoiture }"><c:out value="Modifier" /></a></td>
					<td><a href="formSupprimerVoiture.do?idVoiture=${v.idVoiture }"><c:out value="Supprimer" /></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
<%@ include file="footer.jsp"%>

