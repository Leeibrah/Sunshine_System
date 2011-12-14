package org.fleet.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import org.fleet.classes.*;

public class EmployeeGui extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1448874308107272077L;
	JPanel panel, panelo;
	JLabel label1, label2;
	JTextField txtField;
	JComboBox cBox;
	JButton cancelBtn, okBtn;
	GridBagConstraints c;
	Database db;
	Employee employee;
	String sql;
	
	public EmployeeGui(){
		
		
		panelo = new JPanel();
		panelo.setBounds(5, 15, 25, 23);
		panelo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createLoweredBevelBorder()));
		panel = new JPanel(new GridBagLayout());
		this.add(panelo, "North");
		this.add(panel, "South");
		c = new GridBagConstraints();
		c.insets = new Insets(1, 1, 1, 1);
//		c.gridheight = 0;
//		c.gridwidth = 0;
		c.gridx = 0;
		c.gridy = 0;
		c.ipadx = 0;
		c.ipady = 0;
		label1 = new JLabel("Full names: ");
		panel.add(label1, c);
		
		c.gridx = 1;
		c.gridy = 0;
		txtField = new JTextField(20);
		panel.add(txtField, c);
		
		c.gridx = 0;
		c.gridy = 1;
		label2 = new JLabel("Drive Class: ");
		panel.add(label2, c);
		
		c.gridx = 1;
		c.gridy = 1;
		String [] values = new String[]{"1","2"};
		cBox = new JComboBox(values);
		panel.add(cBox, c);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(this);
		cancelBtn.setSize(20, 20);
		c.gridx = 0;
		c.gridy = 2;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		panel.add(cancelBtn, c);
		
		okBtn = new JButton("Ok");
		okBtn.addActionListener(this);
		c.gridx = 1;
		c.gridy = 2;
		c.weighty = 2.0;
		c.gridheight = 2;
		c.anchor = GridBagConstraints.LAST_LINE_END;
		panel.add(okBtn, c);
		
		setSize(500,300);
		setLocationRelativeTo(null);
		setVisible(true);
		pack();
	}
	
	public void addingValues(){
		db = new Database();
//		employee = new Employee();
//		employee.addEmployee(txtField.getText().toString(), cBox.getSelectedItem().toString());
		
		System.out.println(txtField.getText().toString());
		  System.out.println(cBox.getSelectedItem().toString());
		  
		  String sqlStatement = "INSERT INTO employees_details (" +
		  		"employees_pf, name, drive_class) VALUES(" +
		  		"NULL, '"+txtField.getText().toString()+"'," +
		  		" "+cBox.getSelectedItem().toString()+")";
		  sql = "SELECT * FROM employees_details";
		  db.ExecuteCommand(sqlStatement);
		  db.ExecuteCommand(sql);
	}

	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
        	ex.printStackTrace();
        	} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EmployeeGui egui = new EmployeeGui();
		egui.addingValues();
	}
//	public ad
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		Object ob = ae.getSource();
		if(ob == okBtn){
			if(txtField.getText().equals("")){
				JOptionPane.showMessageDialog(this, "Enter employee details");
			}else{
			 addingValues();	
			 this.dispose();
			 }
		}if(ob == cancelBtn){
//			this.setVisible(false);
			this.dispose();
		}
	}
}
