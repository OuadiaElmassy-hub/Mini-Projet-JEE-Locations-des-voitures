<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>

<%//Test de vérification de modéle et Session %>

<!DOCTYPE html>
<html>
<head>
  <title>Page de Paiement</title>
</head>
<body>
  <div class="container">
    <div class="header">
      <h1>Finalisez votre inscription</h1>
      <p>Paiement sécurisé - <%//=model.montant %> </p>
    </div>
    <div class="cards-logos" aria-label="Logos des cartes acceptées">
      <img src="im3.png" alt="Visa">
      <img src="im2.png" alt="Mastercard">
      <img src="im4.png" alt="American Express">
    </div>
    <form action="" method="POST">
	    <div class="group">
	      <label>Numéro de carte <span class="required">*</span></label>
	      <input 
	        type="text" 
	        name="carte" 
	        placeholder="1234 5678 9012 3456" 
	        maxlength="16"
	        required 
	        class="input">
	    </div>
	    <div class="group">
	      <label>Nom du propriétaire <span class="required">*</span></label>
	      <input 
	        type="text" 
	        name="nomProp" 
	        placeholder="Nom Prénom" 
	        required 
	        class="input">
	    </div>
	    <div class="row">
	      <div class="group">
	        <label>Date d'expiration <span class="required">*</span></label>
	        <input 
	          type="text" 
	          name="dateExp" 
	          placeholder="MM/AA"
	          maxlength="5"
	          required 
	          class="input">
	      </div>
	      <div class="group">
	      <label>CVC <span class="required">*</span></label>
	      <input 
	        type="password" 
	        name="cvv" 
	        maxlength="4" 
	        placeholder="123" 
	        required 
	        class="input">
	      </div>
	    </div>
	    <div class="buttons">
	      <button type="submit" class="btn-submit" >
	      Payer <%//=montant %> DH
	      </button>
	      <a href="Acceuil.php" class="btn-cancel">Annuler</a>
	    </div>
    </form>
    
    <%// validation de reservation si le client a payé et enregistrement dans la bdd %>
    
  </div>
</body>
</html>
<%@ include file="footer.jsp" %>
