
<!-- Fragment qui ram�ne � la page AccueilAvecConnexion -->
<%@ include file="../fragments/fragmentAccueilConnexion.jspf" %>

	<div>
		<div>
			Pseudo : <!-- request.getParameter("spseudo") -->
		</div>
		<br>
		<div>
			Nom : <!-- request.getParameter("snom") -->
		</div>
		<br>
		<div>
			Pr�nom : <!-- request.getParameter("sprenom") -->
		</div>
		<br>
		<div>
			Email : <!-- request.getParameter("semail") -->
		</div>
		<br>
		<div>
			T�l�phone : <!-- request.getParameter("stel") -->
		</div>
		<br>
		<div>
			Rue : <!-- request.getParameter("srue") -->
		</div>
		<br>
		<div>
			Code postal : <!-- request.getParameter("scpo") -->
		</div>
		<br>
		<div>
			Ville : <!-- request.getParameter("sville") -->
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