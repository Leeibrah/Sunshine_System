package org.fleet.gui;

public class Information {
	private int file_num, drive;
	private String name, reg, make, model;
	private boolean isAllocated;
	
	public Information(int file_num, String name, String reg, String make, String model, int drive, boolean isAlocated){
		this.file_num = file_num;
		this.name = name;
		this.reg = reg;
		this.make = make;
		this.model = model;
		this.drive = drive;
		this.isAllocated = isAlocated;
	}

	public int getFile_num() {
		return file_num;
	}

	public void setFile_num(int file_num) {
		this.file_num = file_num;
	}

	public int getDrive() {
		return drive;
	}

	public void setDrive(int drive) {
		this.drive = drive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public boolean isAllocated() {
		return isAllocated;
	}

	public void setAllocated(boolean isAllocated) {
		this.isAllocated = isAllocated;
	}
}
