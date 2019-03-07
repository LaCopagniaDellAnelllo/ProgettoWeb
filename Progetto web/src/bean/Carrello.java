package bean;

import java.util.ArrayList;

public class Carrello {
	private ArrayList<VinoInKart> listaVini;
	
	public Carrello() {
		listaVini = new ArrayList<>();
	}

	public void addToKart(VinoInKart v) {
		boolean presente = false;
		
		/*controllo se il vino è già presente nel carrello*/
		for(VinoInKart vino : listaVini) {
			if(vino.getVino().equals(v.getVino())) {
				int i = listaVini.indexOf(vino);
				vino.setAmount(v.getAmount());
				listaVini.set(i, vino);
				presente = true;
			}
		}
		
		/*se non è presente lo aggiungo*/
		if (!presente) {
			listaVini.add(v);
		}
	}

	public boolean removeToKart(VinoInKart v) {
		/*controllo se il vino è presente nel carrello*/
		for(VinoInKart vino : listaVini) {
			if(vino.getVino().equals(v.getVino())) {
				listaVini.remove(vino);
				return true;
			}
		}
		
		/* se non è presente */
		return false;
		
	}

	public ArrayList<VinoInKart> getKart() {
		return listaVini;
	}
}
