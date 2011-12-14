package org.fleet.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
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
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;

public class VehicleGUI extends JFrame implements ActionListener{
	JButton allocateBtn, unallocateBtn, about;
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem exit;
	JPanel leftPanel, panel, cardPanel;
	CardLayout card;
	
	public VehicleGUI(){
		super("Vehicle System");
		setSize(900,700);
		setVisible(true);
		setLocationRelativeTo(null);
		
		addMenuBar();
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		this.add(panel);
//		panel.add(leftPanel);
		leftPanel = addLeftPanel();
		card = new CardLayout();		
		cardPanel = new JPanel(card);
//		this.add(leftPanel, BorderLayout.WEST);
//		this.add(cardPanel, BorderLayout.CENTER);
		 //adding Labels in CardLayout to the cardPanel 
//        cardPanel.add("one", new First()); 
//        cardPanel.add("two", new Second());
//		cardPanel.add("three", new Three());

		panel.add(leftPanel, BorderLayout.WEST);
		panel.add(cardPanel, BorderLayout.CENTER);
	}


	
	private void addMenuBar() {
		// TODO Auto-generated method stub
		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		menu = new JMenu("Home");
		menuBar.add(menu);
		exit = new JMenuItem(new Action2());
		exit.setMnemonic(KeyEvent.VK_E);
		menu.add(exit);
	}

	private JPanel addLeftPanel() {
		// TODO Auto-generated method stub
		leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		leftPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
		leftPanel.setBorder(BorderFactory.createRaisedBevelBorder());
//		leftPanel.setBackground(Color.BLUE);

		allocateBtn = new JButton("Allocate");
		leftPanel.add(Box.createVerticalStrut(5));

		allocateBtn.addActionListener(this);
		allocateBtn.setActionCommand("a");
		leftPanel.add(allocateBtn);
		unallocateBtn = new JButton("Unallocate");
		leftPanel.add(Box.createVerticalStrut(5));
		unallocateBtn.addActionListener(this);
		unallocateBtn.setActionCommand("b");
		leftPanel.add(unallocateBtn);
		about = new JButton("About");
		leftPanel.add(Box.createVerticalStrut(5));
		about.addActionListener(this);
		about.setActionCommand("c");
		leftPanel.add(about);
		return leftPanel;
	}
	
//	private JPanel centerPanel(){
//		CardLayout card = new CardLayout();
//		cardPanel = new JPanel(card);
//		 //adding Labels in CardLayout to the cardPanel 
//		cardPanel.add("three", new Three());
//        cardPanel.add("one", new First()); 
//        cardPanel.add("two", new Second());
//        return cardPanel;
//	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
	
		Object ob = ae.getSource();
		if(ob.equals(allocateBtn)){
			System.out.println("allocated");
//			clayout.first(cardPanel);
			 card.show(cardPanel, "one"); 
//			cardPanel.add(allocateBtn);
//			centerPanel().setBackground(Color.CYAN);
		}
		if(ob.equals(unallocateBtn)){
//			clayout.next(cardPanel);
			card.show(cardPanel, "two");
			System.out.println("unallocated");

		}
		if(ob.equals(about)){
			card.show(cardPanel, "three");
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
		new VehicleGUI();
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