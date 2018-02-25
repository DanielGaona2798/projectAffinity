package views;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import constants.ConstantsUI;
import controller.Actions;
import controller.Controller;
import models.entities.Gender;
import models.entities.Person;

public class DialogPerson extends JDialog{

	private static final long serialVersionUID = 1L;
	
	private JTextField txtName;
	private JComboBox<Gender> boxGender;
	private JCheckBox checkMovie;
	private JCheckBox checkMusic;
	private JCheckBox checkListening;
	
	public DialogPerson(Controller controller) {
		setTitle("Add Person");
		setIconImage(new ImageIcon("src/img/1.png").getImage());
		setSize(500, 300);
		setLocationRelativeTo(null);
		setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
		getContentPane().setBackground(Color.WHITE);
		
		txtName = new JTextField();
		txtName.setBorder(new TitledBorder("Name"));
		add(txtName);
		
		boxGender = new JComboBox<>(Gender.values());
		boxGender.setBorder(new TitledBorder("Gender"));
		boxGender.setBackground(Color.WHITE);
		add(boxGender);
		
		JPanel panlcheck = new JPanel();
		panlcheck.setLayout(new GridLayout(1, 3));
		panlcheck.setBorder(new TitledBorder("Select things your like"));
		panlcheck.setBackground(Color.WHITE);
		checkMovie = new JCheckBox("movie");
		checkMovie.setBackground(Color.WHITE);
		panlcheck.add(checkMovie);
		
		checkMusic = new JCheckBox("Music");
		checkMusic.setBackground(Color.WHITE);
		panlcheck.add(checkMusic);
		
		checkListening = new JCheckBox("Walk");
		checkListening.setBackground(Color.WHITE);
		panlcheck.add(checkListening);
		
		add(panlcheck);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setBackground(ConstantsUI.COLOR_BTN);
		btnAccept.setForeground(ConstantsUI.COLOR_FORGROUND_BTN);
		btnAccept.setActionCommand(Actions.ADD_PERSON_DIALOG.toString());
		btnAccept.addActionListener(controller);
		add(btnAccept);
	}
	
	public Person getPerson(int idPerson){
		boolean movie = false;
		boolean music = false;
		boolean listening = false;
		if (checkMovie.isSelected()) {
			movie = true;
		}
		if (checkMusic.isSelected()) {
			music = true;
		}
		if (checkListening.isSelected()) {
			listening = true;
		}
		return new Person(idPerson, txtName.getText(),(Gender) boxGender.getSelectedItem(), movie, music,listening);
	}
	
	public void cleanForm(){
		txtName.setText("");
		checkListening.setSelected(false);
		checkMovie.setSelected(false);
		checkMusic.setSelected(false);
	}
}
