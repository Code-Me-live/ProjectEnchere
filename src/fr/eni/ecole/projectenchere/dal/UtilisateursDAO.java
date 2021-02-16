package fr.eni.ecole.projectenchere.dal;

import java.util.List;

import fr.eni.ecole.projectenchere.bo.Utilisateur;

public interface UtilisateursDAO {

	public void insert(Utilisateur utilisateur) throws DALException;
	
	public void update(Utilisateur utilisateur) throws DALException;
	
	public Utilisateur selectById(Integer no_utilisateur) throws DALException;
	
	public void delete(Integer no_utilisateur) throws DALException;
	
	public Utilisateur getUserByEmail (String email) throws DALException;
	
	List<Utilisateur> selectAll() throws DALException;
	
	public Utilisateur selectByMailPseudo(String pseudo, String email) throws DALException;
	
	// public Utilisateur selectByPseudo(String pseudo) throws DALException;
	
	
}
