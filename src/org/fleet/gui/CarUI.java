package org.fleet.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.fleet.classes.Car;
import org.fleet.classes.Database;

public class CarUI extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8361364509360313314L;
	JPanel panelo, panel;
	JButton okBtn, cancelBtn;
	JLabel regLabel, makelabel, modellabel, drivelabel;
	JTextField txtField;
	JComboBox makechbox, modelchbox, drivechbox;
	GridBagConstraints c;
	Database db;
	Car car;
	
	public CarUI(){
		super("New Car");
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
		regLabel = new JLabel("Vehicle Registration: ");
		panel.add(regLabel, c);
		
		c.gridx = 1;
		c.gridy = 0;
		txtField = new JTextField(20);
		panel.add(txtField, c);
		
		c.gridx = 0;
		c.gridy = 1;
		makelabel = new JLabel("Vehicle make: ");
		panel.add(makelabel, c);
		
		c.gridx = 1;
		c.gridy = 1;
		String [] values = new String[]{"Ford","Mazda", "Toyota"};
		makechbox = new JComboBox(values);
		panel.add(makechbox, c);
		
		modellabel = new JLabel("Vehicle model: ");
		
		c.gridx = 0;
		c.gridy = 2;
//		c.anchor = GridBagConstraints.FIRST_LINE_START;
		panel.add(modellabel, c);
		
		
		c.gridx = 1;
		c.gridy = 2;
		String [] models = new String[]{"Ford","Mazda", "Toyota"};
		modelchbox = new JComboBox(models);
		panel.add(modelchbox, c);
		
		c.gridx = 0;
		c.gridy = 3;
		drivelabel = new JLabel("Drive Class: ");
		panel.add(drivelabel, c);
		
		c.gridx = 1;
		c.gridy = 3;
		String [] drives = new String[]{"1","2"};
		drivechbox = new JComboBox(drives);
		panel.add(drivechbox, c);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(this);
		cancelBtn.setSize(20, 20);
		c.gridx = 0;
		c.gridy = 4;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		panel.add(cancelBtn, c);
		
		okBtn = new JButton("Ok");
		okBtn.addActionListener(this);
		c.gridx = 1;
		c.gridy = 4;
		c.weighty = 2.0;
		c.gridheight = 2;
		c.anchor = GridBagConstraints.LAST_LINE_END;
		panel.add(okBtn, c);
		
		setSize(700,400);
		setLocationRelativeTo(null);
		setVisible(true);
		pack();
	}
	
	public void addingValues(){
		db = new Database();
		String sqlStatement = "INSERT INTO vehicle_details (vehicle_reg, vehicle_make, vehicle_model, drive_class) " +
				"VALUES(" +
				"'"+txtField.getText().toString()+"'," +
				"'"+makechbox.getSelectedItem().toString()+"'," +
				"'"+modelchbox.getSelectedItem().toString()+"',"+
				"'"+drivechbox.getSelectedItem().toString()+"')";
		
		db.ExecuteCommand(sqlStatement);
		String sql = "SELECT * FROM vehicle_details";
		db.ExecuteCommand(sql);
	}
	
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		Object ob = ae.getSource();
		if(ob == okBtn){
			if(txtField.getText().equals("")){
				JOptionPane.showMessageDialog(this, "Enter vehicle reg");
				return;
			}else{
				addingValues();
//				CarViews car = new CarViews();
				new VehicleUI().repaint();
//				this.repaint();
				this.dispose();
				return;
			}	
		}if(ob == cancelBtn){
			this.dispose();
		}
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
		new CarUI();
	}
	
}
