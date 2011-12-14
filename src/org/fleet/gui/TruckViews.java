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


public class TruckViews extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6066144888276577313L;

	Vector<Trucks> truck = null;

	SystemUtilities utils;
	String temp;
	
	public TruckViews(SystemUtilities utils) {
		this.utils = utils;
		truck = utils.getTrucks();
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
		String[] columns = { "Registration Number", "Model", "Weight", "Drive Class" };

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return truck.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columns.length;
		}

		@Override
		public Object getValueAt(int row, int column) {
			// TODO Auto-generated method stub
			Trucks trucks = truck.get(row);
			switch (column) {
			case 0:
				return trucks.getReg();
			case 1:
				return trucks.getModel();
			case 2:
				return trucks.getWeight();
			case 3:
				return trucks.getDrive();
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
			Trucks trucks = truck.get(row);    
			temp=trucks.getReg();

			switch (col) {
			case 0:
				
				trucks.setReg((String)value);
				break;
			case 1:
				trucks.setModel((String)value);
				break;
			case 2:
				trucks.setWeight((Double) value);
				break;
			case 3:
				trucks.setDrive((String)value);
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
				PreparedStatement ps = c.prepareStatement("UPDATE vehicle_details SET vehicle_reg = ?,vehicle_model = ?,vehicle_weight = ?,drive_class=? WHERE vehicle_reg ='"+temp+"'");
				ps.setString(1, (String)model.getValueAt(row, 0));
				ps.setString(2, (String)model.getValueAt(row, 1));
				ps.setDouble(3, (Double) model.getValueAt(row, 2));
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
