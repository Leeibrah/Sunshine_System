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

public class InformationViews extends JPanel{
	private static final long serialVersionUID = 6066144888276577313L;

	Vector<Information> info = null;

	SystemUtilities utils;
	String temp;
	
	public InformationViews(SystemUtilities utils) {
		this.utils = utils;
		info = utils.getInformation();
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
			return info.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columns.length;
		}

		@Override
		public Object getValueAt(int row, int column) {
			// TODO Auto-generated method stub
			Information infos = info.get(row);
//			Trucks cars = truck.get(row);
			switch (column) {
			case 0:
				return infos.getFile_num();
			case 1:
				return infos.getName();
			case 2:
				return infos.getReg();
			case 3:
				return infos.getMake();
			case 4:
				return infos.getModel();
			case 5:
				return infos.getDrive();
			case 6:
				return infos.isAllocated();
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
			Information information = info.get(row);    
			temp=information.getReg();

			switch (col) {
			case 0:
				information.setFile_num((Integer) value);
				break;
			case 1:
				information.setName((String)value);
				break;
			case 2:
				information.setReg((String)value);
				break;
			case 3:
				information.setMake((String)value);
				break;
			case 4:
				information.setModel((String)value);
				break;
			case 5:
				information.setDrive((Integer)value);
				break;
			case 6:
				information.isAllocated();
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
