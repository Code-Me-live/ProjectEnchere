<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acceuil</title>
</head>
<body>

	<h1>ENI-Encheres</h1>
	<!-- HREF � FAIRE -->
	<a href="#">Ench�res</a>
	<a href="#">Vendre un article</a>
	<a href="#">Mon profil</a>
	<a href="#">D�connexion</a>

	<h2>Liste des ench�res</h2>

	<P>Filtres :</P>

	<form action="" method="post">
		<input type="search">
		<button>RECHERCHE</button>
	</form>

	<!-- Cat�gorie avec liste d�roulante -->
	<label>Cat�gorie : </label>
	<select>
		<option>Toutes</option>
		<option>Informatique</option>
		<option>Ameublement</option>
		<option>V�tement</option>
		<option>Sport&Loisirs</option>
	</select>
	<br>

	<!-- RESTE D�validation des checkbox � faire selon Achats ou Mes Ventes -->
	<input type="radio" id="achats" name="name" value="achats" checked>
	<label for="achats">Achats</label>
	<div>
  		<input type="checkbox" id="enchOuvertes" name="enchOuvertes"><label for="enchOuvertes"> Ench�res ouvertes</label><br>
  		<input type="checkbox" id="mesEncheres" name="mesEncheres"><label for="mesEncheres"> Mes ench�res</label><br>
  		<input type="checkbox" id="reporte" name="reporte"><label for="reporte"> Mes ench�res report�es</label><br><br>
	</div>

	<input type="radio" id="ventes" name="name" value="ventes">
	<label for="ventes">Mes ventes</label>
	<div>
  		<input type="checkbox" id="enCours" name="encours"><label for="encours"> Mes ventes en cours</label><br>
  		<input type="checkbox" id="nonDebute" name="nonDebute"><label for="nonDebute"> Ventes non d�but�es</label><br>
  		<input type="checkbox" id="termine" name="termine"><label for="termine"> Ventes termin�es</label><br>
	</div>

	<hr>

	<h3> Liste des ench�res en cours � afficher</h3>

</body>
</html>