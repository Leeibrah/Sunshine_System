package org.fleet.classes;

public class Car extends Vehicle{
	Database db;
	
	
	public Car(){
		db = new Database();
	}
	
	public void printTruck(){
		System.out.println(getRegNumber()+"\t"+getMake()+"\t"+getModel()+"\t"+getDriveClass());
		
		
		
	}
	public String toString(){
		return getRegNumber()+""+getMake()+""+getModel()+""+getDriveClass();
	}
	
	public void addCar(String reg, String make, String model, String drive){
		db = new Database();
		  System.out.println("work");
	}
	public static void main(String[] args) {
		
		Car t = new Car();
//		t.addCar("Krs", "mazda", "toyota", "2");
		System.err.println("Reg. Number\tMake\tModel\tDrive Class");
		t.setRegNumber("KBG 234K");
		t.setMake("Toyota");
		t.setModel("Van");
		t.setDriveClass(2);
		
		Car p = new Car();
		p.setRegNumber("KAS 345U");
		p.setMake("Pick Up");
		p.setModel("Isuzu");
		p.setDriveClass(2);

		t.printTruck();
		p.printTruck();
		p.toString();
	}
}
