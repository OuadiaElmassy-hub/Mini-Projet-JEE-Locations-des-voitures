<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Nouvelle voiture</title>
</head>
<body>
	<form action="ajouterVoiture.do" method="post" >

		<label>Matricule :</label> <input type="text" name="matricule"
			required><br>
		<br> <label>Marque :</label> <input type="text" name="marque"
			required><br>
		<br> <label>Modèle :</label> <input type="text" name="modele"
			required><br>
		<br> <label>Catégorie :</label> <select name="categorie" required>
			<option value="">-- Choisir --</option>
			<option value="Citadine">Citadine</option>
			<option value="Ludospace">Ludospace</option>
			<option value="SUV">SUV</option>
			<option value="Luxe">Luxe</option>
		</select><br>
		<br> <label>Prix par jour :</label> <input type="number"
			name="prixJour" required><br>
		<br> <label>Image :</label> <input type="text" name="image"
			required><br>
		<br>

		<button type="submit">Ajouter</button>

	</form>
</body>
</html>