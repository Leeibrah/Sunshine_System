package org.fleet.classes;

public abstract class Vehicle {
	public String regNum;
	public String make;
	public String model;
	public int driveClass;
	
	public Vehicle(){
		
	}

	public String getRegNumber() {
		return regNum;
	}

	public void setRegNumber(String regNum) {
		this.regNum = regNum;
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

	public int getDriveClass() {
		return driveClass;
	}

	public void setDriveClass(int driveClass) {
		this.driveClass = driveClass;
	}
	
}
