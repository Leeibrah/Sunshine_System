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
import org.fleet.gui.TruckViews.TableModel;

public class EmployeesView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1361148014354129028L;

	Vector<Employees> employee = null;

	SystemUtilities utils;
	int temp;
	
	public EmployeesView(SystemUtilities utils) {
		this.utils = utils;
		employee = utils.getEmployees();
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
		String[] columns = { "Registration Number", "Name", "Drive Class" };

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return employee.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columns.length;
		}

		@Override
		public Object getValueAt(int row, int column) {
			// TODO Auto-generated method stub
			Employees employees = employee.get(row);
			switch (column) {
			case 0:
				return employees.getFile_num();
			case 1:
				return employees.getName();
			case 2:
				return employees.getDrive();
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
			Employees employees = employee.get(row);    
			temp=employees.getFile_num();

			switch (col) {
			case 0:
				
				employees.setFile_num((Integer) value);
				break;
			case 1:
				employees.setName((String) value);
				break;
			case 2:
				employees.setDrive((Integer) value);
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
				PreparedStatement ps = c.prepareStatement("UPDATE vehicle_details SET vehicle_reg = ?,vehicle_model = ?,drive_class=? WHERE vehicle_reg ='"+temp+"'");
				ps.setString(1, (String)model.getValueAt(row, 0));
				ps.setString(2, (String)model.getValueAt(row, 1));
				ps.setString(3, (String)model.getValueAt(row, 2));
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
