
<!-- Fragment qui ram�ne � la page AccueilASansConnexion -->
<%@ include file="../fragments/fragmentAccueilSansConnexion.jspf" %>

<form method="post" action="inscription">
	<fieldset>
		<legend>Mon profil

<label for="pseudo">Pseudo :<span class="requis">*</span></label>
<input type="text" id="pseudo" name="pseudo" value="" size="20" maxlength="60">

<br />

<label for="name">Nom :<span class="requis">*</span></label>
<input type="text" id="name" name="name" value="" size="20" maxlength="60">

<br />

<label for="firstname">Pr�nom :<span class="requis">*</span></label>
<input type="text" id="firstname" name="firstname" value="" size="20" maxlength="60">

<br />

<label for="email">Email :<span class="requis">*</span></label>
<input type="text" id="email" name="email" value="" size="20" maxlength="60">

<br />

<label for=phone>T�l�phone :<span class="requis">*</span></label>
<input type="text" id="phone" name="phone" value="" size="20" maxlength="60">

<br />

<label for="street">Rue :<span class="requis">*</span></label>
<input type="text" id="street" name="street" value="" size="20" maxlength="60">

<br />

<label for="postalCode">Code Postal :<span class="requis">*</span></label>
<input type="text" id="postalCode" name="postalCode" value="" size="20" maxlength="60">

<br />

<label for="city">Ville :<span class="requis">*</span></label>
<input type="text" id="city" name="city" value="" size="20" maxlength="60">

<br />

<label for="passWord">Mot de passe :<span class="requis">*</span></label>
<input type="text" id="passWord" name="passWord" value="" size="20" maxlength="60">

<br />

<label for="confirmation">Confirmation :<span class="requis">*</span></label>
<input type="text" id="confirmation" name="confirmation" value="" size="20" maxlength="60">

<br />
			<!-- en appuyant sur cr�er, on arrive � la page d'accueil connect� (liste ench�res -->
				<a href="<%= request.getContextPath()%>/accueilAvecConnexion.html"><input type="submit" value="Cr�er"></a>
		
			<br>
			
				<a href="<%= request.getContextPath() %>/accueil.html"><input type="submit" value="Annuler"></a>
			</legend></fieldset></form>
</body>