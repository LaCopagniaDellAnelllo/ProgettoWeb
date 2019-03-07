package bean;

public class Utente {
	private String id;
	private String nome;
	private String cognome;
	private String eMail;
	private String password;
	private String username;
	
	public Utente() {
		
	}

	public Utente(String id, String nome, String cognome, String eMail, String password, String username) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.eMail = eMail;
		this.password = password;
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	
}
