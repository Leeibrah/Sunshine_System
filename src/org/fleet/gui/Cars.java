package org.fleet.gui;

public class Cars {
	private String reg, make, model, drive;

	public Cars(String reg, String make, String model, String drive) {
		super();
		this.reg = reg;
		this.make = make;
		this.model = model;
		this.drive = drive;
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
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
}
