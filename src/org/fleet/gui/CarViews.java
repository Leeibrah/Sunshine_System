package org.fleet.gui;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import org.fleet.classes.SystemUtilities;


public class CarViews extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3331834737478731990L;

	Vector<Cars> car = null;

	SystemUtilities utils;
	String temp;
	
	public CarViews(SystemUtilities utils) {
		this.utils = utils;
		car = utils.getCars();
		makeView();
	}

	private void makeView() {
		// TODO Auto-generated method stub
		TableModel xy=new TableModel();
		JTable table = new JTable(xy);
		table.setAutoscrolls(true);
		table.getModel().addTableModelListener(xy);
		JScrollPane pane = new JScrollPane(table);
		this.setLayout(new BorderLayout());
		this.add(pane);
	}

	class TableModel extends AbstractTableModel implements TableModelListener{

		/**
		 * 
		 */
		private static final long serialVersionUID = 9136990113274189782L;
		String[] columns = { "Registration Number", "Make", "Model", "Drive Class" };

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return car.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columns.length;
		}

		@Override
		public Object getValueAt(int row, int column) {
			// TODO Auto-generated method stub
			Cars cars = car.get(row);
			switch (column) {
			case 0:
				return cars.getReg();
			case 1:
				return cars.getMake();
			case 2:
				return cars.getModel();
			case 3:
				return cars.getDrive();
			}
			return null;
		}

		@Override
		public String getColumnName(int column) {
			return columns[column];
		}
		
		@Override		
		public boolean isCellEditable(int row, int col){
			return true; 
		}  
		
		public void setValueAt(Object value, int row, int col) {  
			Cars cars = car.get(row);    
			temp=cars.getReg();

			switch (col) {
			case 0:
				
				cars.setReg((String)value);
				break;
			case 1:
				cars.setMake((String)value);
				break;
			case 2:
				cars.setModel((String)value);
				break;
			case 3:
				cars.setDrive((String)value);
				break;
			}
  
		    fireTableCellUpdated(row, col);  
		}

		@Override
		public void tableChanged(TableModelEvent e) {
			// TODO Auto-generated method stub
			int row = e.getFirstRow();  
			//int column = e.getColumn();  
			TableModel model = (TableModel)e.getSource();  
			if(e.getType()==TableModelEvent.UPDATE){
				try{
				Connection c = utils.getConn();
				PreparedStatement ps = c.prepareStatement("UPDATE vehicle_details SET vehicle_reg = ?,vehicle_make = ?,vehicle_model = ?,drive_class=? WHERE vehicle_reg ='"+temp+"'");
				ps.setString(1, (String)model.getValueAt(row, 0));
				ps.setString(2, (String)model.getValueAt(row, 1));
				ps.setString(3, (String)model.getValueAt(row, 2));
				ps.setString(4, (String)model.getValueAt(row, 3));
				ps.executeUpdate();
				ps.close();
				System.out.println("Courses Table Updated");
				}
				catch(SQLException re){
					re.printStackTrace();
				}
			}
		}  
		 
	}
}
