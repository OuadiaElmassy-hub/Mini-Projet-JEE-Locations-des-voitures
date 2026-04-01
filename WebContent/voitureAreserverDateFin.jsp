<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>Détails sur la Voiture</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<div class="voiture-container">
		<div>
			<img
				src="${pageContext.request.contextPath}/images/voitures/${voiture.image}"
				alt="${voiture.marque} ${voiture.modele}">
		</div>
						
		<div>
			<h3>${voiture.marque} ${voiture.modele}</h3>
			<p>
				Catégorie : <span>${voiture.categorie}</span>
			</p>
			<p class="price">
				<strong>${voiture.prixJour}</strong> DH / jour
			</p>
		</div>
		<div>
			<form action="paiement.do" method="GET">
				Date de Retour : <input type="date" name="dateRetour" value="${empty param.dateRetour ? twodays : param.dateRetour}" />
				<input type="hidden" name="idVoiture" value="${param.idVoiture}" />
				<input type="submit" value="Alouer maintenant" />
			</form>
		</div>	
	</div>
</body>
</html>
<%@ include file="footer.jsp" %>