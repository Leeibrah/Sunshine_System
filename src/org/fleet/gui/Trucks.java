package org.fleet.gui;

public class Trucks {
	private String reg, model, drive;
	double weight;

	

	public Trucks(String reg, String model, double weight, String drive){
		this.reg = reg;
		this.model = model;
		this.weight = weight;
		this.drive = drive;
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDrive() {
		return drive;
	}

	public void setDrive(String drive) {
		this.drive = drive;
	}
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}
