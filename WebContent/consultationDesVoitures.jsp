<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<%@ include file="menu.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<title>Page de Consultation</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
	<style>
	  img {
	      width: 350px;
	      height: 200px;
	      object-fit: cover;
	  }
	</style>
	
</head>
<body>
	<div>
		<!-- formulaire de recherche des voitures on se basant sur date de reservation et categories -->
		<form action="chercher.do" method="GET">
			<label>Date de Reservation :</label><br><br>
			<label>Début :</label> <input type="date" name="dateDebut"
				value="${empty param.dateDebut ? today : param.dateDebut}"><br><br>
			<label>Catégorie :</label><br><br>
			<table>
				<tr>
					<td>Tout</td><td><input type="radio" name="categorie" value="tout"
						${empty param.categorie || param.categorie == 'tout' ? 'checked' : ''}>
					<!-- n'importe quelle categorie -->
					</td>
				</tr><tr>
					<td>Citadine</td><td><input type="radio" name="categorie" value="citadine"
						${param.categorie == 'citadine' ? 'checked' : ''}>
					</td>
				</tr><tr>
					<td>SUV</td><td><input type="radio" name="categorie" value="suv"
						${param.categorie == 'suv' ? 'checked' : ''}>
					</td>
				</tr><tr>
					<td>Ludospace</td><td><input type="radio" name="categorie" value="ludospace"
						${param.categorie == 'ludospace' ? 'checked' : ''}>
					</td>
				</tr><tr>
					<td>Luxe</td><td><input type="radio" name="categorie" value="luxe"
						${param.categorie == 'luxe' ? 'checked' : ''}>
					</td>
				</tr><tr>
			</table><br>
			<input type="submit" value="Rechercher">
		</form>
	</div>
	<hr />
	<div>
		<!-- Affichage des résultats -->
		<!-- on utilisant jstl -->
		<c:if test="${not empty voitures}">
			<div>
				<c:forEach var="voiture" items="${voitures}">
					<div class="car-card">
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
						<a href="${pageContext.request.contextPath}/voiture.do?idVoiture=${voiture.idVoiture}">
						    <button>Réserver maintenant</button>
						</a>
						<!-- Ou bien une petite formulaire -->
					</div>
				</c:forEach>
			</div>
		</c:if>
	</div>

</body>
</html>
<%@ include file="footer.jsp"%>