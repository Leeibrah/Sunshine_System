package org.fleet.gui;

public class Employees {
	private int file_num, drive;
	private String name;
	
	public Employees(int file_num, String name, int drive){
		this.file_num = file_num;
		this.name = name;
		this.drive = drive;
				
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
}
