
<!-- Fragment qui ram�ne � la page AccueilAvecConnexion -->
<%@page import="fr.eni.ecole.projectenchere.bo.Utilisateur"%>
<%@ include file="../fragments/fragmentAccueilConnexion.jspf" %>


<!-- cr�er variable sous include pour la r�cup�rer  -->
<!-- mettre variable pseudo dans les <> -->
<%!
	Utilisateur utilisateur;
%>

	<div>
		<div>
			Pseudo : <%=request.getAttribute("pseudo") %>
		</div>
		<br>
		<div>
			Nom : <%=request.getAttribute("nom") %>
		</div>
		<br>
		<div>
			Pr�nom : <%=request.getAttribute("prenom") %>
		</div>
		<br>
		<div>
			Email : <%=request.getAttribute("email") %>
		</div>
		<br>
		<div>
			T�l�phone : <%=request.getAttribute("telephone") %>
		</div>
		<br>
		<div>
			Rue : <%=request.getAttribute("rue") %>
		</div>
		<br>
		<div>
			Code postal : <%=request.getAttribute("code_postal") %>
		</div>
		<br>
		<div>
			Ville : <%=request.getAttribute("ville") %>
		</div>
		<br>
		<div>
			<a href="<%= request.getContextPath() %>/monProfil.html">
			<input type="submit" value="Modifier">
			</a>
		</div>
	</div>
</body>
</html>