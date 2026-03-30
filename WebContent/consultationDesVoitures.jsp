<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>

<!--Test de vérification de modéle et Session -->

<!DOCTYPE html>
<html>
<head>
	<title>Page de Consultation</title>
</head>
<body>
	<div><!-- formulaire de recherche des voitures on se basant sur date de reservation et categories -->
		<form action="consultation.php" method="GET">
			<label>Date de Reservation :</label><br><br>
			<label>Début :</label>
			<input type="date" name="dateDebut" value="${empty param.dateDebut ? today : param.dateDebut}"><br><br>
			<label>Catégorie :</label><br><br>
			Tout <input type="radio" name="categorie" value="tout" 
						${empty param.categorie || param.categorie == 'tout' ? 'checked' : ''} ><br><!-- n'importe quelle categorie -->
			SBN <input type="radio" name="categorie" value="sbn" 
						${param.categorie == 'sbn' ? 'checked' : ''} ><br>
			Sport <input type="radio" name="categorie" value="sport" 
						${param.categorie == 'sport' ? 'checked' : ''} ><br><br>
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