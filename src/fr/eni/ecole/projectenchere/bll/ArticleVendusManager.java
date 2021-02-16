package fr.eni.ecole.projectenchere.bll;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import fr.eni.ecole.projectenchere.bo.ArticleVendu;
import fr.eni.ecole.projectenchere.dal.ArticlesVendusDAO;
import fr.eni.ecole.projectenchere.dal.DAOFactory;

public class ArticleVendusManager {

	private ArticlesVendusDAO daoArticlesVendus = null;
	
	public ArticlesVendusDAO ArticlesVendusManager() {
		
		return daoArticlesVendus = DAOFactory.getArticlesVendusDAO();
	}
	

	public void verifArticle(ArticleVendu article) {
		if (article.getPrixVente() == null) {
			article.setPrixVente(article.getPrixInitial());
		}
	}
	



 
	
}
