package org.fleet.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import org.fleet.gui.*;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


public class SystemUtilities {
	public SystemUtilities() {
		initConnection();
	}

	private void initConnection() {
		// TODO Auto-generated method stub
		MysqlDataSource ds = new MysqlDataSource();
		ds.setServerName("localhost");
		ds.setDatabaseName("sunshine");
		ds.setUser("root");
		ds.setPassword("sqlyella");
		try {
			Connection c = ds.getConnection();
			System.out.println("Connection ok");
			this.setConn(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the conn
	 */
	public Connection getConn() {
		return conn;
	}

	/**
	 * @param conn
	 *            the conn to set
	 */
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	private Connection conn;

	public static void main(String[] args) {
		new SystemUtilities();
	}

	public Vector<Cars> getCars() {
		// TODO Auto-generated method stub
		Vector<Cars> v = new Vector<Cars>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from vehicle_details order by vehicle_reg");
			while (rs.next()) {
				String reg = rs.getString(1);
				String make = rs.getString(2);
				String model = rs.getString(3);
				String drive = rs.getString(4);
				Cars cars = new Cars(reg, make, model, drive);
				v.add(cars);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}
	
	public Vector<Trucks> getTrucks() {
		// TODO Auto-generated method stub
		Vector<Trucks> v = new Vector<Trucks>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("select vehicle_reg, vehicle_model, vehicle_weight, drive_class from vehicle_details order by vehicle_reg");
			while (rs.next()) {
				String reg = rs.getString(1);
				String model = rs.getString(2);
				double weight = rs.getDouble(3);
				String drive = rs.getString(4);
				Trucks truck = new Trucks(reg, model, weight, drive);
//				Cars cars = new Truck(reg, model, drive);
				v.add(truck);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return v;
	}

		public Vector<Employees> getEmployees() {
			// TODO Auto-generated method stub
			Vector<Employees> v = new Vector<Employees>();
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt
						.executeQuery("select * from employees_details order by employees_pf");
				while (rs.next()) {
					int file_num = rs.getInt(1);
					String name = rs.getString(2);
					int drive = rs.getInt(3);
					Employees employee = new Employees(file_num, name, drive);
//					Cars cars = new Truck(reg, model, drive);
					v.add(employee);
				}
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}
		
		public Vector<Information> getInformation() {
			// TODO Auto-generated method stub
			Vector<Information> v = new Vector<Information>();
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt
						.executeQuery("");
				while (rs.next()) {
					int file_num = rs.getInt(1);
					String name = rs.getString(2);
					String reg = rs.getString(3);
					String make = rs.getString(4);
					String model = rs.getString(5);
					int drive = rs.getInt(6);
					boolean isAllocated  = rs.getBoolean(7);
					Information info = new Information(file_num, name, reg, make, model, drive, isAllocated);
//					Cars cars = new Truck(reg, model, drive);
					v.add(info);
				}
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}
	
	public enum StatusFlag{SUCCESS, FAILED, RESET}; 
		public static String sqlCommandFilter(String sqlCommand){
  		/*** method not yet complete **/
		return sqlCommand;
		}
}