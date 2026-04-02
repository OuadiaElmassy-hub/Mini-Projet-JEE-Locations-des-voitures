<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>

<!DOCTYPE html><html>
<head>
<title>Modification de la voiture</title>
</head>
<body>
	<form action="modifierVoiture.do" method="post" >

		<input type="hidden" name="idVoiture"
			value="${voiture.idVoiture }" >

		<label>Matricule :</label> <input type="text" name="matricule"
			value="${voiture.matricule }" required><br>
		<br> <label>Marque :</label> <input type="text" name="marque"
			value="${voiture.marque }"  required><br>
		<br> <label>Modèle :</label> <input type="text" name="modele"
			value="${voiture.modele }" required><br>
		<br> <label>Catégorie :</label> <select name="categorie" required>
			<option value="" >-- Choisir --</option>
			<option value="Citadine" ${voiture.categorie == 'Citadine' ? 'selected' : ''}>Citadine</option>
			<option value="Ludospace" ${voiture.categorie == 'Ludospace' ? 'selected' : ''}>Ludospace</option>
			<option value="SUV" ${voiture.categorie == 'SUV' ? 'selected' : ''}>SUV</option>
			<option value="Luxe" ${voiture.categorie == 'Lux' ? 'selected' : ''}>Luxe</option>
		</select><br>
		<br> <label>Prix par jour :</label> <input type="number"
			name="prixJour" step="0.01" value="${voiture.prixJour }" required><br>
		<br> <label>Image :</label> <input type="text" name="image"
			value="${voiture.image }" required><br>
		<br>

		<button type="submit">Modifier</button>

	</form>
</body>
</html>