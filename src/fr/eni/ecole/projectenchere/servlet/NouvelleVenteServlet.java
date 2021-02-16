package fr.eni.ecole.projectenchere.servlet;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.projectenchere.bll.ArticleVendusManager;
import fr.eni.ecole.projectenchere.bo.ArticleVendu;
import fr.eni.ecole.projectenchere.dal.DALException;



/**
 * Servlet implementation class NouvelleVenteServlet
 */
@WebServlet("/NouvelleVente.html")
public class NouvelleVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public NouvelleVenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/nouvelleVente.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArticleVendu articleAVendre = new ArticleVendu();
		ArticleVendusManager artA = new ArticleVendusManager();
		
		
		String article = request.getParameter("sarticle");
		String description = request.getParameter("sdescription");
		String categorie = request.getParameter("Categorie");
		//Cast du String en Int
		int prixInitial = Integer.parseInt(request.getParameter("sprix"));
/*************CAST DE DATE A FAIRE************************************/
		String dateD = request.getParameter("sdate_debut");
		String dateF = request.getParameter("sdate_fin");
		Date dateDebut = Date.valueOf(dateD);
		Date dateFin = Date.valueOf(dateF);
/*************CAST DE DATE A FAIRE************************************/

		String rue = request.getParameter("srue");
		String codePostal = request.getParameter("scodepostal");
		String ville = request.getParameter("sville");
		
		response.getWriter().append("sarticle : "+article+"<br> "
				+ "sdescription : "+description+"<br> "
				+ "Catégorie : "+categorie+"<br> Prix "
				+ "Date de Début : "+dateDebut+"<br> "
				+ "Date de Fin : "+dateFin+"<br> "
				+ "initial : "+prixInitial+"<br> "
				+ "Rue : "+rue+"<br> "
				+ "Code postal : "+codePostal+"<br>"
				+ " Ville : "+ville );
		
		
		try {
			artA.verifArticle(articleAVendre);
			artA.ArticlesVendusManager().insert(articleAVendre);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}
	
	
	
	
	}

