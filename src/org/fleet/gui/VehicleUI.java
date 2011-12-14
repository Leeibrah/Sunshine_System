package org.fleet.gui;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;

import org.fleet.classes.SystemUtilities;

public class VehicleUI extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4629081577521431408L;
	private JButton allocateBtn, unallocateBtn, addEmpBtn, carBtn, truckBtn, employBtn, addCarBtn, allBtn, infoBtn;
	private JMenuBar menuBar;
	private JMenu menu, helpMenu;
	private JMenuItem exit, about;
	private JPanel leftPanel;
	private CarViews first;
	private TruckViews second;
	private InformationViews four;
	private GridBagConstraints c;
	private EmployeesView three;
	SystemUtilities utils;
	
	public VehicleUI() {
		// TODO Auto-generated constructor stub
		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		menu = new JMenu("Home");
		menuBar.add(menu);
		exit = new JMenuItem(new Action2());
		exit.setMnemonic(KeyEvent.VK_E);
		menu.add(exit);
		
		helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		about = new JMenuItem(new Action3());
		about.setMnemonic(KeyEvent.VK_B);
		helpMenu.add(about);
		
		utils = new SystemUtilities();
		first = new CarViews(utils);
		second = new TruckViews(utils);
		three = new EmployeesView(utils);
		
		add(addLeftPanel(), BorderLayout.WEST);
		add(first, BorderLayout.CENTER);
		add(addBottomPanel(), BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		pack();
//		setLocationRelativeTo(this);
		setVisible(true);
		setSize(1000,600);
		setLocationRelativeTo(null);
	}

	private JPanel addLeftPanel() {
		// TODO Auto-generated method stub
		leftPanel = new JPanel();
		leftPanel.setLayout(new GridBagLayout());
		leftPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
		leftPanel.setBorder(BorderFactory.createRaisedBevelBorder());

		c = new GridBagConstraints();
		c.insets = new Insets(2, 2, 2, 2);
		c.gridx = 0;
		c.gridy = 0;

		carBtn = new JButton("Car");
		carBtn.addActionListener(this);
		carBtn.setActionCommand("a");
		carBtn.setPreferredSize(new Dimension(100, 50));

		c.fill = GridBagConstraints.VERTICAL;
		leftPanel.add(carBtn, c);
		c.gridx = 0;
		c.gridy = 1;
		truckBtn = new JButton("Truck");
		truckBtn.setPreferredSize(new Dimension(100, 50));

		leftPanel.add(Box.createVerticalStrut(5));
		truckBtn.addActionListener(this);
		truckBtn.setActionCommand("b");
		leftPanel.add(truckBtn, c);
		c.gridx = 0;
		c.gridy = 2;
		employBtn = new JButton("Employees");
		leftPanel.add(Box.createVerticalStrut(5));
		employBtn.setPreferredSize(new Dimension(100, 50));

		employBtn.addActionListener(this);
		employBtn.setActionCommand("c");
		leftPanel.add(employBtn, c);
		c.gridx = 0;
		c.gridy = 3;
		allBtn = new JButton("Information");
		leftPanel.add(Box.createVerticalStrut(5));
		allBtn.addActionListener(this);
		allBtn.setActionCommand("d");
		allBtn.setPreferredSize(new Dimension(100, 50));
		leftPanel.add(allBtn, c);
		return leftPanel;
	}
	
	public JPanel addBottomPanel(){
		JPanel btmpanel = new JPanel();
//		btmpanel.setLayout(new BoxLayout(leftPanel, BoxLayout.X_AXIS));
		btmpanel.setLayout(new GridLayout(1,3));
//		btmpanel.setAlignmentY(BOTTOM_ALIGNMENT);
//		btmpanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btmpanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
		btmpanel.setBorder(BorderFactory.createRaisedBevelBorder());
//		leftPanel.setBackground(Color.BLUE);

		
		
		addCarBtn = new JButton("Add Car");
		addCarBtn.addActionListener(this);
		addCarBtn.setActionCommand("c");
		btmpanel.add(addCarBtn);
		btmpanel.add(Box.createHorizontalStrut(5));
		
		addEmpBtn = new JButton("Add Employee");
		addEmpBtn.addActionListener(this);
		addEmpBtn.setActionCommand("c");
		btmpanel.add(addEmpBtn);
		btmpanel.add(Box.createHorizontalStrut(5));
		
		allocateBtn = new JButton("Allocate");
		allocateBtn.addActionListener(this);
		allocateBtn.setActionCommand("a");
		btmpanel.add(allocateBtn);
		btmpanel.add(Box.createHorizontalStrut(5));

		unallocateBtn = new JButton("Unallocate");
		unallocateBtn.addActionListener(this);
		unallocateBtn.setActionCommand("b");
		btmpanel.add(unallocateBtn);
		
		return btmpanel;
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
		new VehicleUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		
		if(object == carBtn){
			this.remove(second);
			this.remove(three);
			this.add(first, BorderLayout.CENTER);
			this.validate();
			this.repaint();
		}else if(object == truckBtn){
			this.remove(first);
			this.remove(three);
			this.add(second, BorderLayout.CENTER);
			this.validate();
			this.repaint();
		}else if(object == employBtn){
			this.remove(first);
			this.remove(second);
			this.add(three, BorderLayout.CENTER);
			this.validate();	
			this.repaint();
		}else if(object == allBtn){
			this.remove(first);
			this.remove(second);
			this.add(four, BorderLayout.CENTER);
			this.validate();
			this.repaint();
		}else if(object == addCarBtn){
			new CarUI();
		}else if(object == addEmpBtn){
			new EmployeeGui();
		}
	}
	
	class Action2 extends AbstractAction {
	    Action2() {
	       super("Exit");
	       putValue(MNEMONIC_KEY,1);
	    }
	    public void actionPerformed(ActionEvent arg0) {
	    	System.exit(0);
	    }
	}
	class Action3 extends AbstractAction {
	    Action3() {
	       super("About");
	       putValue(MNEMONIC_KEY,1);
	    }
	    public void actionPerformed(ActionEvent arg0) {
	    	new AboutUI();
	    }
	}
}
