
<!-- Fragment qui ram�ne � la page AccueilAvecConnexion -->
<%@ include file="../fragments/fragmentAccueilConnexion.jspf" %>


	<a href="<%=request.getContextPath()%>/NouvelleVente.html">Vendre un article</a>
	<a href="<%=request.getContextPath()%>/profilUtilisateur.html">  Mon profil</a>
	<a href="<%=request.getContextPath()%>/accueil.html">  D�connexion </a>

	<h2>Liste des ench�res</h2>

	<P>Filtres :</P>

	<form action="" method="post">
		<input type="search">
		<button>RECHERCHE</button>
	</form>
	<br>

	<!-- Cat�gorie avec liste d�roulante -->
	<label>Cat�gorie : </label>
	<select>
		<option>Toutes</option>
		<option>Informatique</option>
		<option>Ameublement</option>
		<option>V�tement</option>
		<option>Sport&#38;Loisirs</option>
	</select>
	<br>
	<br>

	<form>
	<div class="achat">
	<input type="radio" id="achats" name="name" value="achats" checked onclick="selectAchatOuVente(this)">
	<label for="achats">Achats</label><br>
  		<input type="checkbox" id="1" name="sAchats">
  		<label for="enchOuvertes"> Ench�res ouvertes</label><br>
  		<input type="checkbox" id="2" name="sAchats">
  		<label for="mesEncheres"> Mes ench�res</label><br>
  		<input type="checkbox" id="3" name="sAchats">
  		<label for="reporte"> Mes ench�res report�es</label><br><br>
	</div>
	
	<div class="vente">
	<input type="radio" id="ventes" name="name" value="ventes" onclick="selectAchatOuVente(this)">
	<label for="ventes">Mes ventes</label><br>
  		<input type="checkbox" id="4" name="sVentes">
  		<label for="encours"> Mes ventes en cours</label><br>
  		<input type="checkbox" id="5" name="sVentes">
  		<label for="nonDebute"> Ventes non d�but�es</label><br>
  		<input type="checkbox" id="6" name="sVentes">
  		<label for="termine"> Ventes termin�es</label><br>
	</div>
	</form>
	<br>
	<br>
	
	<hr>

<!-- RETOUR DAL A FAIRE POUR AFFICHAGE DE LA LISTE -->
	<h3> Liste des ench�res en cours � afficher</h3>
<!-- RETOUR DAL A FAIRE POUR AFFICHAGE DE LA LISTE -->

<form action="<%=request.getContextPath()%>/DetailVente.html" method="get">
<input  type="submit" value="Articles">
</form>

</body>
</html>