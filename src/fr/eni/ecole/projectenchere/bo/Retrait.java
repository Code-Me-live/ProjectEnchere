package fr.eni.ecole.projectenchere.bo;

public class Retrait {

	private String rue;
	private String code_postal;
	private String ville;
	
	//Constructeur
	public Retrait(String rue, String code_postal, String ville) {
	}

	//Getter et Setter
	
	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	//M�thode public
	@Override
	public String toString() {
		return "Retrait [rue=" + rue + ", code_postal=" + code_postal + ", ville=" + ville + "]";
	}
	
	
	
	
	
	
}
