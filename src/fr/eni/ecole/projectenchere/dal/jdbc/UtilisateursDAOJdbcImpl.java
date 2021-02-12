package fr.eni.ecole.projectenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.projectenchere.bo.Utilisateur;
import fr.eni.ecole.projectenchere.dal.DALException;
import fr.eni.ecole.projectenchere.dal.DBConnexion;
import fr.eni.ecole.projectenchere.dal.UtilisateursDAO;


public class UtilisateursDAOJdbcImpl implements UtilisateursDAO {
	
	//Constantes
	 private static final String INSERT_UTILISATEUR = "INSERT INTO Utilisateurs (pseudo, nom, prenom, email, "
	 		+ "telephone, rue, code_postal, ville, mot_de_passe, credit)"
	 		+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	 private static final String UPDATE_UTILISATEUR = "UPDATE Utilisateurs SET (pseudo = ?, nom = ?, prenom = ?,"
	 		+ "email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?)"
	 		+ "WHERE no_utilisateur = ?";
	 
	 private static final String SELECT_BY_ID_UTILISATEUR = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue,"
	 		+ "code_postal, ville FROM Utilisateurs WHERE no_utilisateur = ?";
	
	 private static final String DELETE_BY_ID_UTILISATEUR = "DELETE FROM Utilisateurs WHERE no_utilisateur = ?";
	 
	 private static final String SELECT_ALL_UTILISATEUR = "SELECT no_utilisateur, pseudo, prenom, nom, email, telephone,"
	 		+ "rue, code_postal, ville FROM Utilisateurs";
	 
//	 private static final String SELECT_BY_PSEUDO_UTILISATEUR = "SELECT pseudo, nom , prenom, email, telephone, rue, code_postal"
//	 		+ "ville FROM Utilisateurs WHERE pseudo LIKE ?";

	 
	/**
	 * Méthode permettant d'insérer un utilisateur
	 */
	@Override
	public void insert(Utilisateur utilisateur) throws DALException {
		// quand un utilisateur s'inscrit, un crédit de 100 lui est alloué -> à faire dans méthode
		
		
		if (utilisateur == null) {
			throw new DALException("Pas d'utilisateur en paramètre");
		}
		
		Connection connexion = DBConnexion.seConnecter();
		PreparedStatement pstmt = null;
		
		try {
			// désactivation de l'auto commit
			connexion.setAutoCommit(false);
			// insertion des utilisateurs et récupération de l'identity
			pstmt = connexion.prepareStatement(INSERT_UTILISATEUR, Statement.RETURN_GENERATED_KEYS);
			
			// respecter ordre requête sql pour les paramètres 1, 2, 3...
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			
			// exécution de la requête
			pstmt.executeUpdate();
			
			// lecture de la clef primaire générée par la BDD
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int no_utilisateur = rs.getInt(1);
				utilisateur.setNoUtilisateur(no_utilisateur);
			}
			
			pstmt.close();
			// commit
			connexion.commit();

		} catch (SQLException e) {
			try {
				connexion.rollback();
			} catch (SQLException e1) {
				throw new DALException("Erreur lors de la création d'un utilisateur : " + utilisateur, e1);
			}
			throw new DALException("Erreur lors de la création d'un utilisateur : " + utilisateur, e);	
			
		} finally {
			try {
				connexion.setAutoCommit(true);
				connexion.close();
			} catch (SQLException e) {
				throw new DALException("Erreur lors de la création d'un utilisateur : " + utilisateur, e);
			}
		}
	}



	/**
	 * Méthode permettant de mettre à jour le profil utilisateur
	 */
	@Override
	public void update(Utilisateur utilisateur) throws DALException {
		Connection connexion = DBConnexion.seConnecter();
		PreparedStatement pstmt = null;
		
		
		try {
			connexion.setAutoCommit(false);
			
			pstmt = connexion.prepareStatement(UPDATE_UTILISATEUR);
	
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			
			pstmt.setInt(10, utilisateur.getNoUtilisateur());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			// commit
			connexion.commit();

		} catch (SQLException e) {
			try {
				connexion.rollback();
			} catch (SQLException e1) {
				throw new DALException("Erreur lors de l'update de l'utilisateur : " + utilisateur, e1);
			}
			throw new DALException("Erreur lors de l'update de l'utilisateur : " + utilisateur, e);	
			
		} finally {
			try {
				connexion.setAutoCommit(true);
				connexion.close();
			} catch (SQLException e) {
				throw new DALException("Erreur lors de l'update de l'utilisateur : " + utilisateur, e);
			}
		}

	}


	/**
	 * Méthode permettant d'afficher le profil d'un utilisateur grace à son numéro d'utilisateur
	 */
	@Override
	public Utilisateur selectById(Integer no_utilisateur) throws DALException {
		ResultSet rs = null;
		Connection connexion = DBConnexion.seConnecter();
		PreparedStatement pstmt = null;
		Utilisateur utilisateur = new Utilisateur();
		
		connexion = DBConnexion.seConnecter();
		
		try {
		
			pstmt = connexion.prepareStatement(SELECT_BY_ID_UTILISATEUR);
			pstmt.setInt(1, no_utilisateur);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
					utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"), 
						rs.getString("prenom"),rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), 
						rs.getString("code_postal"), rs.getString("ville"));
			}
		
			
		} catch (SQLException e) {
			throw new DALException("Erreur lors de la sélection de l'utilisateur par son numéro : " + no_utilisateur, e);
			
		} finally {
			try {	
				if(pstmt != null) {
					pstmt.close();
				}
				
				if(connexion != null) {
					connexion.close();
				}
				
			} catch (SQLException e) {
				throw new DALException("Erreur lors de la sélection de l'utilisateur par son numéro : " + no_utilisateur, e);
			}
		}
		
		return utilisateur;

	}


	/**
	 * Méthode permettant de supprimer un utilisateur par rapport à son numéro d'utilisateur
	 */
	@Override
	public void delete(Integer no_utilisateur) throws DALException {
		Connection connexion = DBConnexion.seConnecter();
		PreparedStatement pstmt = null; 
		
		
		try {
			pstmt = connexion.prepareStatement(DELETE_BY_ID_UTILISATEUR);
			
			pstmt.setInt(1, no_utilisateur);
			
			pstmt.executeUpdate();
			
			
			pstmt.close();
			// commit
			connexion.commit();

		} catch (SQLException e) {
			try {
				connexion.rollback();
			} catch (SQLException e1) {
				throw new DALException("Erreur lors de la suppression de l'utilisateur : " + no_utilisateur, e1);
			}
			throw new DALException("Erreur lors de la suppression de l'utilisateur : " + no_utilisateur, e);	
			
		} finally {
			try {
				connexion.setAutoCommit(true);
				connexion.close();
			} catch (SQLException e) {
				throw new DALException("Erreur lors de la suppression de l'utilisateur : " + no_utilisateur, e);
			}
		}
		
	}


	/**
	 * Méthode permettant d'afficher une liste d'utilisateurs
	 */
	@Override
	public List<Utilisateur> selectAll() throws DALException {
		List<Utilisateur> listeUtilisateurs = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Connection connexion = DBConnexion.seConnecter();
		
		try {
			pstmt = connexion.prepareStatement(SELECT_ALL_UTILISATEUR);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Utilisateur utilisateur = null;
				
				utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"), 
						rs.getString("prenom"),rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), 
						rs.getString("code_postal"), rs.getString("ville"));
				
				if (listeUtilisateurs == null) {
				listeUtilisateurs = new ArrayList<Utilisateur>();
				}
				
				listeUtilisateurs.add(utilisateur);
				
			}

			
		} catch (SQLException e) {
			throw new DALException("Erreur lors de la sélection de tous les utilisateurs : " +e);
		} finally {
			DBConnexion.seDeconnecter(connexion, pstmt);
		}
		
		
		
		return listeUtilisateurs;
	}



//	@Override
//	public Utilisateur selectByPseudo(String pseudo) throws DALException {
//		ResultSet rs = null;
//		Connection connexion = DBConnexion.seConnecter();
//		PreparedStatement pstmt = null;
//		Utilisateur utilisateur = new Utilisateur();
//		
//		connexion = DBConnexion.seConnecter();
//		
//		try {
//			pstmt = connexion.prepareStatement(SELECT_BY_PSEUDO_UTILISATEUR);
//			pstmt.setString(1, pseudo);
//			
//			rs = pstmt.executeQuery();
//
//			if (rs.next()) {
//				utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), 
//						rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), rs.getString("code_postal"), 
//						rs.getString("ville"));
//			}
//
//		} catch (SQLException e) {
//			throw new DALException("Erreur lors de la sélection de l'utilisateur par son pseudo : " + pseudo, e);
//			
//		} finally {
//			try {	
//				if(pstmt != null) {
//					pstmt.close();
//				}
//				
//				if(connexion != null) {
//					connexion.close();
//				}
//				
//			} catch (SQLException e) {
//				throw new DALException("Erreur lors de la sélection de l'utilisateur par son pseudo : " + pseudo, e);
//			}
//		}
//		
//		return utilisateur;
//	}

	 
	 
}
