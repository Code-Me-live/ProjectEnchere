package fr.eni.ecole.projectenchere.bll;



import fr.eni.ecole.projectenchere.bo.Utilisateur;
import fr.eni.ecole.projectenchere.dal.DALException;
import fr.eni.ecole.projectenchere.dal.DAOFactory;
import fr.eni.ecole.projectenchere.dal.UtilisateursDAO;


public class UtilisateurManager {

	private UtilisateursDAO daoUtilisateur;

	public UtilisateurManager() {
		//Instancier le Data Acess Object (DAO)
		//Charger une instance de l'utilisateurdaojdbcimpl via la factory
		daoUtilisateur = DAOFactory.getUtilisateursDAO();
	}
	//Appeler la DAO
	//Appeler une méthode qui recherche l'email
	//"" recherche pseudo
	//

	/**
	 * parcourir tous les emails SELECTALL
	 * @param newUtilisateur
	 * @throws DALException 
	 * @throws BLLException
	 */
	//	public void addUtilisateur(Utilisateur newUtilisateur) throws BLLException {
	//Vérifier que le mail n'hésite pas déjà
	//faire appel à la methode getEmail de la UtilisateurDAOjdbcImpl

	//		if(newUtilisateur.getEmail()!=null) {
	//			throw new BLLException("Cet email existe déjà");
	//		}
	//		try {
	//			validerUtilisateur(newUtilisateur);
	//			daoUtilisateur.insert(newUtilisateur);
	//		} catch (DALException e) {
	//			throw new BLLException("Echec addUtilisateur", e);
	//		}
	//	}

	//vérification email 
	public Utilisateur validerEmail(String email) {
		Utilisateur utilisateur = new Utilisateur();
		boolean checkFormulaire;

		try {
			UtilisateursDAO utilisateurDao = null;
			utilisateur = utilisateurDao.getUserByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (utilisateur.getEmail().isEmpty()) {
			return utilisateur;
		}else {
			checkFormulaire = false;
		}
		return null;


	} 
	public void addUtilisateur(Utilisateur newUser) throws BLLException {
		if (newUser.getNoUtilisateur()!=null) {
			throw new BLLException("utilisateur déjà existant");
		}
		try {
			validerUtilisateur(newUser);
		daoUtilisateur.insert(newUser);
		} catch (DALException e) {
		throw new BLLException("Echec addUtilisateur", e);
		}
	}

	private void validerUtilisateur(Utilisateur u) throws BLLException {
	//vérifier les différents champs du formulaire 
	
	
		boolean valide =  true;
		StringBuffer sb = new StringBuffer();

		if (u.getPseudo() == null) {
			sb.append("Veuillez saisir un pseudo. \n");
			valide = false;		
		} else if (!u.getPseudo().matches("[A-Za-z0-9_]+")) {
			sb.append("Le pseudo saisi n'est pas valide. \n");
			valide = false;
		}
		if (u.getNom() == null) {
			sb.append("Veuillez saisir un nom \n");
			valide = false;
		}else if (u != null && u.getNom().trim().length()>30) {
			sb.append("Le nom ne doit pas dépasser 30 caractères \n");
			valide = false;
		}
		if (u.getPrenom() == null) {
			sb.append("Veuillez saisir un prenom");
			valide = false;
		}else if (u != null && u.getPrenom().trim().length()>30) {
			sb.append("Le prenom ne doit pas dépasser 30 caractères");
			valide = false;
		}
		if (u.getEmail() != null && u.getEmail().trim().length()>100)  {
			if (!u.getEmail().matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")){
				sb.append("Merci de saisir une adresse mail valide.\n");
				valide = false;
			}else if (u.getEmail() == null) {
				sb.append("L'adresse mail doit être renseignée \n");
				valide = false;
			}
		}else {
			sb.append("L'adresse mail ne doit pas dépasser 100 caractères\n");
			valide = false;
		}
		if (u.getTelephone() != null && u.getTelephone().trim().length()>10) {
			sb.append("Le numéro de téléphone doit comporter au moins 10 chiffres \n");
			valide = false;
		}else if (!u.getTelephone().matches("\\+?[0-9][0-9][0-9]([0-9][0-9])+")) {
			sb.append("Le numéro de téléphone saisi n'est pas valide \n");
			valide = false;
		}else if (u.getTelephone() == null) {
			sb.append("Le numéro de téléphone doit être renseigné \n");
			valide = false;
		}
		if (u.getRue() != null && u.getRue().trim().length()>50) {
			sb.append("Merci de saisir un nom de rue valide \n");
			valide = false;
		}else if (u.getRue() == null) {
			sb.append("Merci de saisir un nom de rue \n ");
			valide = false;
		}
		if (u.getCodePostal() != null && u.getCodePostal().trim().length()>5) {
			sb.append("Le code postal doit comporter 5 chiffres \n");
			valide = false;
		}else if (u.getCodePostal() == null) {
			sb.append("Veuillez saisir un code postal \n");
			valide = false;
		}
		if (u.getVille() != null && u.getVille().length()>30) {
			sb.append("Merci de saisir un nom de ville valide \n");
			valide = false;
		}else if (u.getVille() == null) {
			sb.append("Merci de saisir un nom de ville \n ");
			valide = false;
		}
		
		if (!valide) {
			throw new BLLException(sb.toString());
		}
	}
	
	public void motDePasse (String motDePasse, String confirmationMDP) throws BLLException {
		
		boolean valide =  true;
		StringBuffer sb = new StringBuffer();
		
		if (motDePasse != null && motDePasse.trim().length()!=0 
				&& confirmationMDP != null && confirmationMDP.trim().length() != 0) {
			if (!motDePasse.equals(confirmationMDP)) {
				sb.append("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
				valide = false;
			}else if (motDePasse.trim().length() > 6) {
				sb.append("Les mots de passe doivent contenir au moins 6 caractères.");
				valide = false;
			} //doit-on définir la taille des champs
		}else {
			sb.append("Merci de saisir et confirmer votre mot de passe.");
			valide = false;
		}
		if (!valide) {
			throw new BLLException(sb.toString());
		}
	}

	
}


