
<!-- Fragment qui ram�ne � la page AccueilAvecConnexion -->
<%@page import="fr.eni.ecole.projectenchere.bo.Utilisateur"%>
<%@ include file="../fragments/fragmentAccueilConnexion.jspf" %>

<% Utilisateur u = (Utilisateur) request.getAttribute("utilisateur"); %>

	<div>
		<div>
			Pseudo : <%=u.getPseudo() %>
		</div>
		<br>
		<div>
			Nom : <%=u.getNom() %>
		</div>
		<br>
		<div>
			Pr�nom : <%=u.getPrenom() %>
		</div>
		<br>
		<div>
			Email : <%=u.getEmail() %>
		</div>
		<br>
		<div>
			T�l�phone : <%=u.getTelephone() %>
		</div>
		<br>
		<div>
			Rue : <%=u.getRue() %>
		</div>
		<br>
		<div>
			Code postal : <%=u.getCodePostal() %>
		</div>
		<br>
		<div>
			Ville : <%=u.getVille() %>
		</div>
		<br>
	</div>
</body>
</html>