package bean;

public class VinoInKart {
	private int amount;
	private Vino vino;
	
	public VinoInKart() {
		amount = 0;
		vino = new Vino();
	}
	
	public void setVino(Vino v) {
		vino = v;
	}
	
	public Vino getVino() {
		return vino;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
