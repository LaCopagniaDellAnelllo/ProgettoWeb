package bean;

public class Vino {

	private String idVino;
	private double centilitri;
	private double prezzo;
	private String immagine;
	private String descrizione;
	private String vinoSfusoNome;
	private String vinoSfusoAnno;
	
	public Vino() {
	}

	public Vino(String idVino, double centilitri, double prezzo, String immagine, String descrizione,
			String vinoSfusoNome, String vinoSfusoAnno) {
		this.idVino = idVino;
		this.centilitri = centilitri;
		this.prezzo = prezzo;
		this.immagine = immagine;
		this.descrizione = descrizione;
		this.vinoSfusoNome = vinoSfusoNome;
		this.vinoSfusoAnno = vinoSfusoAnno;
	}

	
	public String getIdVino() {
		return idVino;
	}

	
	public void setIdVino(String idVino) {
		this.idVino = idVino;
	}

	
	public double getCentilitri() {
		return centilitri;
	}

	
	public void setCentilitri(double centilitri) {
		this.centilitri = centilitri;
	}

	
	public double getPrezzo() {
		return prezzo;
	}

	
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	
	public String getImmagine() {
		return immagine;
	}

	
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	
	public String getDescrizione() {
		return descrizione;
	}

	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	
	public String getVinoSfusoNome() {
		return vinoSfusoNome;
	}

	
	public void setVinoSfusoNome(String vinoSfusoNome) {
		this.vinoSfusoNome = vinoSfusoNome;
	}

	
	public String getVinoSfusoAnno() {
		return vinoSfusoAnno;
	}

	
	public void setVinoSfusoAnno(String vinoSfusoAnno) {
		this.vinoSfusoAnno = vinoSfusoAnno;
	}
	
	
	
	
}
