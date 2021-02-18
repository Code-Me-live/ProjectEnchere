
<!-- Fragment qui ram�ne � la page AccueilAvecConnexion -->
<%@page import="fr.eni.ecole.projectenchere.bo.Categories"%>
<%@page import="fr.eni.ecole.projectenchere.bo.ArticleVendu"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ include file="../fragments/fragmentAccueilConnexion.jspf" %>

<div class="ml-3">
	<a href="<%=request.getContextPath()%>/NouvelleVente.html">Vendre un article</a>
	<a href="<%=request.getContextPath()%>/profilUtilisateur.html">  Mon profil</a>
	<a href="<%=request.getContextPath()%>/seDeconnecter.html">  D�connexion </a>

<div class="d-flex justify-content-center">
	<h2>Liste des ench�res</h2>
</div>

	<P>Filtres :</P>

	<form action="<%=request.getContextPath()%>/accueilAvecConnexion.html" method="post">
		<input type="search" name="sRechercher" placeholder="Search" aria-label="Search">
		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Rechercher</button>
	</form>

	<!-- Cat�gorie avec liste d�roulante Dynamique avec la BDD -->
	<label>Cat�gorie : </label>
	<label>Cat�gorie : </label>
	<form action="<%=request.getContextPath()%>/Categorie.html" method="get">
		<select name="Categorie" onchange="submit()">
		<option value="0">Toutes</option>
		<%
		List<Categories> listeC = (List<Categories>) request.getAttribute("listeCategorie");
		for(Categories listeCat : listeC){
			int noCategorie = listeCat.getNoCategorie();
			String libelle = listeCat.getLibelle();
			%>
			<option value="<%=noCategorie%>"><%=libelle %></option>
		
		<%} %>
		</select>
	</form>
	<br>
	<br>

	<form class="row">
	<div class="achat col">
	<input type="radio" id="achats" name="name" value="achats" checked onclick="selectAchatOuVente(this)">
	<label for="achats">Achats</label><br>
		
  		<input type="checkbox" id="1" name="sAchats" checked>
  		<label for="enchOuvertes" > Ench�res ouvertes</label><br>
  		<input type="checkbox" id="2" name="sAchats">
  		<label for="mesEncheres"> Mes ench�res</label><br>
  		<input type="checkbox" id="3" name="sAchats">
  		<label for="reporte"> Mes ench�res report�es</label><br><br>
  		
	</div>
	
	<div class="vente col">
	<input type="radio" id="ventes" name="name" value="ventes" onclick="selectAchatOuVente(this)">
	<label for="ventes">Mes ventes</label><br>
  		<input type="checkbox" id="4" name="sVentes">
  		<label for="encours"> Mes ventes en cours</label><br>
  		<input type="checkbox" id="5" name="sVentes">
  		<label for="nonDebute"> Ventes non d�but�es</label><br>
  		<input type="checkbox" id="6" name="sVentes">
  		<label for="termine"> Ventes termin�es</label><br>
	</div>
	<div class="vente col"></div>
	</form>
	<br>
	<br>
	
	<hr>

<!-- RETOUR DAL A FAIRE POUR AFFICHAGE DE LA LISTE -->
		<div class="d-flex flex-wrap">
			<%
			List<ArticleVendu> liste = (List<ArticleVendu>) request.getAttribute("listeArticles");
			for(ArticleVendu articleVendu : liste){
				String nom = articleVendu.getNomArticle();
				int prix =articleVendu.getPrixInitial();
				Date date = articleVendu.getDateFinEncheres();
				String vendeur = articleVendu.getPseudo();
				%>
				<div class="card border-primary m-1 p-2" style="max-width: 18rem;">
				<div class="card-header" ><a href="<%=request.getContextPath()%>/DetailVente.html?noArticle=<%=articleVendu.getNoArticle()%>"><%=nom %></a></div>
				<img alt="#image" src="">
				<h5 class="card-title">Prix : <%=prix %> k&#128;</h5>
				<p class="card-text">Date de fin d'ench�re : <%=date %><br></p>
				<p> Vendeur : <a href="<%=request.getContextPath()%>/profilUtilisateur.html"><%=vendeur %></a></p>
				</div>
			<%}%>
		</div>
<!-- RETOUR DAL A FAIRE POUR AFFICHAGE DE LA LISTE -->


</div>
</body>
</html>