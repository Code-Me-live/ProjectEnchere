
<!-- Fragment qui ram�ne � la page AccueilAvecConnexion -->
<%@ include file="../fragments/fragmentAccueilConnexion.jspf" %>

<!-- Pseudo utilisateur a integrer -->
	<h1>PseudoUtilisateur a remport�e la vente</h1>
	<form action="<%=request.getContextPath()%>//accueilAvecConnexion.html" method="get">
	<div>
		<label><a href="Nom de l'article"></a>Titre de l'article</label>
	</div>
	<br>
	<div>
		<label><a href="Description"></a>Description :</label>
	</div>
	<br>
	<div>
		<label>Mise � prix :</label>
	</div>
	<br>
	<div>
		<label>Fin de l'ench�re :</label>
	</div>
	<br>

	<br>
	<div>
		<label>Retrait :</label>
	</div>
	<br>
	<div>
		<label>Vendeur :</label>
	</div>
	<br>
	<div>
		<input type="submit" value="retour">
	</div>
	</form>
</body>
</html>