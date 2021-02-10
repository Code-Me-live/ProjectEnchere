<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1 UTF-8">
<title>Nouvelle vente</title>
</head>
<body>
	<h1>Nouvelle vente</h1>

	<!-- Cr�ation des cat�gories Article et Description -->

		<div>
			<label>Article</label> <input type="text">
		</div>

		<br>
		<div>
			<label>Description</label> <input type="text">
		</div>
		<br>
		<!-- Cat�gorie avec menu d�roulant -->
		<div>
			<label>Cat�gorie</label> <select>
				<option>Informatique</option>
				<option>Ameublement</option>
				<option>V�tement</option>
				<option>Sport&Loisirs</option>
			</select>
		</div>
		<br>
		
		<!-- Uploader une photo -->
		<div>
			<label for="article">Photo de l'article</label> <input type="file"
				id="article" name="article" accept="image/png, image/jpeg">
		</div>
		<br>
		
		<!--  Menu d�roulant pour le prix -->
		<div>
			<label for="prix">Mise � prix</label> <input type="number" id="prix"
				name="prix" min="1" max="1000">
		</div>
		
		<!-- Date de d�but et de fin enchere--> 
		<div>
			<label for="debut">D�but de l'ench�re</label>
		</div>
		<input type="date" id="debut" name="date_debut" value="/ /">
		<br>
		<div>
			<label for="fin">Fin de l'ench�re</label>
		</div>
		<input type="date" id="debut" name="date_fin" value="/ /">

		<br>
	<br>

	<!-- Partie retrait -->
	<fieldset>
		<legend>Retrait</legend>
		<div>
			<label>Rue :</label> <input type="text">
		</div>
		<br>
		<div>
			<label>Code Postal :</label> <input type="text">

		</div>
		<br>
		<div>
			<label>Ville :</label> <input type="text">

		</div>
		<br>
	</fieldset>
	
	<!--  Enregistrer ou Annuler -->

	<div>
	<a href="<%= request.getContextPath() %>/accueilAvecConnexion.html">
		<input type="submit" value="Enregistrer">
		</a>
	</div>
	<br>
	<div>
	<a href="<%= request.getContextPath() %>/accueilAvecConnexion.html">
		<input type="submit" value="Annuler"></a>
	</div>
	<!--  en fonction de la date de d�but d'enchere et la tete du jour, bouton "annuler la vente" -->

</body>
</html>