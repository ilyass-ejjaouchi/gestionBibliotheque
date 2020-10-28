package ensa.liberarie.entities;

public class Document {
	
	protected long id;
	protected boolean disponible;
	protected int quantité;


	public Document() {
		super();
	}
	
	public Document(long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public boolean getDisponible() {
		return quantité >0 ? true:false;
	}

	
	public int getQuantité() {
		return quantité;
	}

	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public void moinQuantité() {
		quantité--;
	}
	
	public void plusQuantité() {
		quantité++;
	}

	
	
	

	
}
