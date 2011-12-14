package org.fleet.classes;

public class Truck extends Vehicle{
	
	public Truck(){
		
	}
	
	

	public void printTruck(){
		System.out.println(getRegNumber());
		System.out.println(getMake().toString());
		System.out.println(getModel());
		System.out.println(getDriveClass());
	}
	public static void main(String[] args) {
		Truck t = new Truck();
		t.setRegNumber("KBG 234K");
		t.setMake("Mazda");
		t.setModel("Saxo");
		t.setDriveClass(2);

		t.printTruck();
	}
}
