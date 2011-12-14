package org.fleet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AboutUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5870448038273750719L;
	private JPanel  imgPanel, txtPanel;
	JLabel txtLabel;
	private ImageIcon icon;
	private JButton btn;
	private GridBagConstraints c;
	
	public AboutUI(){
		super("About Sunshine Company");
		setLayout(new GridBagLayout());
		
		imgPanel = new JPanel();
		btn = new JButton("Ok");

		c = new GridBagConstraints();
		c.insets = new Insets(2, 2, 2, 2);
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		icon = new ImageIcon("res/logo.jpg");
		imgPanel.add(new JLabel(icon));
		add(imgPanel, c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_END;
		txtLabel = new JLabel("<html>Sunshine is a Vehicle<br /> Company which allocates <br />cars to its employees</html>", SwingConstants.CENTER);
		txtPanel = new JPanel();
//		txtPanel.setBackground(Color.white);
		add(txtPanel, c);
		txtPanel.add(txtLabel, c);
//		add(txtPanel, "East");
		
		
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LAST_LINE_END;
		btn.setPreferredSize(new Dimension(80, 30));
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		add(btn, c);
		
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new AboutUI();
	}
}
