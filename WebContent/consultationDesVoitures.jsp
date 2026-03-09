<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>

<%//Test de vérification de modéle et Session %>

<!DOCTYPE html>
<html>
<head>
	<title>Page de Consultation</title>
</head>
<body>
	<div><!-- formulaire de recherche des voitures on se basant sur date de reservation et categories -->
		<form action="consultation" method="GET"><!-- on peut utiliser get -->
			<label>Date de Reservation :</label><br><br>
			<label>Début :</label>
			<input type="date" name="dateDebut" value="<%//=model.dateDebut %>"><br><br>
			<label>Fin :</label>
			<input type="date" name="dateFin" value="<%//=model.dateFin %>"><br><br>
			<label>Catégorie :</label><br><br>
			Tout <input type="radio" name="categorie" value="tout" ><br><!-- n'importe quelle categorie -->
			SBN <input type="radio" name="categorie" value="sbn" ><br>
			Sport <input type="radio" name="categorie" value="sport" ><br><br>
			<input type="submit" value="Rechercher">
		</form>	
	</div>
	
	<div><!-- Affichage des résultats -->
		<!-- soit des cartes ou un tableau -->
		<hr/>
		<!-- on utilisant jstl -->
		<c:if test="${not empty resultats}">
		    <table border="1">
		        <tr><th>Voiture</th><th>Catégorie</th><th>Date dispo</th></tr>
		        <c:forEach var="v" items="${resultats}">
		            <tr>
		                <td>${v.nom}</td>
		                <td>${v.categorie}</td>
		                <td>${v.dateDispo}</td>
		            </tr>
		        </c:forEach>
		    </table>
		</c:if>
	</div>
</body>
</html>
<%@ include file="footer.jsp" %>