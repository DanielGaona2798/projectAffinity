package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import constants.ConstantsUI;
import controller.Actions;
import controller.Controller;
import models.entities.Person;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private PanelTableMan tableMan;
	private MenuBar menuBar;
	
	public MainWindow(Controller controller) {
		setTitle("Affinity 1.0");
		setLayout(new BorderLayout());
		setIconImage(new ImageIcon("src/img/1.png").getImage());
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		menuBar = new MenuBar(controller);
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		tableMan = new PanelTableMan();
		add(tableMan, BorderLayout.CENTER);
		
		JPanel panelLow = new JPanel();
		panelLow.setBackground(Color.WHITE);
		JButton btnAffinity = new JButton("Calculate Affinity");
		btnAffinity.setBackground(ConstantsUI.COLOR_BTN);
		btnAffinity.setForeground(Color.WHITE);
		btnAffinity.setActionCommand(Actions.CALCULATE_AFFINITY.toString());
		btnAffinity.addActionListener(controller);	
		panelLow.add(btnAffinity);
		add(panelLow, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public void refreshTableMan(ArrayList<Person> personList){
		tableMan.refreshTable(personList);
	}
	
	public int getmanSelected(){
		return tableMan.getSelectedPersonId();
	}
	public int[] getcheckselec(){
		return tableMan.getCheckSelected();
	}

	public void quitCheck() {
		tableMan.quitCheck();
	}
}
