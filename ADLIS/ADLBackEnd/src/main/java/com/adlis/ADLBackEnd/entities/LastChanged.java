package com.adlis.ADLBackEnd.entities;

public class LastChanged {
	private String fin;
	private String lastChange;
	
	public LastChanged(String fin, String lastChange) {
		super();
		this.fin = fin;
		this.lastChange = lastChange;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public String getLastChange() {
		return lastChange;
	}

	public void setLastChange(String lastChange) {
		this.lastChange = lastChange;
	}
}
