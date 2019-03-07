package bean;

public class Utente {
	private String idUtente;
	private String nome;
	private String cognome;
	private String eMail;
	private String password;
	private String username;
	private boolean admin;
	
	public Utente() {
		
	}

	public Utente(String id, String nome, String cognome, String eMail, String password, String username, boolean admin) {
		super();
		this.idUtente = id;
		this.nome = nome;
		this.cognome = cognome;
		this.eMail = eMail;
		this.password = password;
		this.username = username;
		this.admin = admin;
	}

	public String getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(String id) {
		this.idUtente = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getMail() {
		return eMail;
	}

	public void setMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public boolean isAdmin() {
		return admin;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
}
