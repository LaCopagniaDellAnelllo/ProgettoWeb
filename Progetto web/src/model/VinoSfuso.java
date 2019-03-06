package model;

public class VinoSfuso {

	private String nome;
	private int anno;
	private String igp;
	private int litri;
	private String qualitaUva;
	
	
	public VinoSfuso() {
		
	}
	
	public VinoSfuso(String nome, int anno, String igp, int litri, String qualitaUva) {
		this.nome = nome;
		this.anno = anno;
		this.igp = igp;
		this.litri = litri;
		this.qualitaUva = qualitaUva;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public String getIgp() {
		return igp;
	}
	public void setIgp(String igp) {
		this.igp = igp;
	}
	public int getLitri() {
		return litri;
	}
	public void setLitri(int litri) {
		this.litri = litri;
	}
	public String getQualitaUva() {
		return qualitaUva;
	}
	public void setQualitaUva(String qualitaUva) {
		this.qualitaUva = qualitaUva;
	}
	
	
	
}
