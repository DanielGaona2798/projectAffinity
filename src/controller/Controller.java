package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import constants.ConstantsUI;
import models.dao.PersonMannager;
import persistence.TextFileManager;
import views.DialogAffinity;
import views.DialogPerson;
import views.MainWindow;

public class Controller implements ActionListener{
	private MainWindow mainWindow;
	private DialogPerson dialogPerson;
	private PersonMannager personMannager;
	private DialogAffinity dialogAffinity;
	private TextFileManager fileManager;
	
	public Controller() throws IOException {
		mainWindow = new MainWindow(this);
		dialogPerson = new DialogPerson(this);
		personMannager = new PersonMannager();
		dialogAffinity = new DialogAffinity();
		fileManager = new TextFileManager();
		personMannager.createArrayPerson(fileManager.readFile(ConstantsUI.PATH));
		mainWindow.refreshTableMan(personMannager.getPersonList());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch (Actions.valueOf(arg0.getActionCommand())) {
		case ADD_PERSON:
			dialogPerson.setVisible(true);
			break;
		case ADD_PERSON_DIALOG:
			addPersonDialog();
			break;
		case CALCULATE_AFFINITY:
			calculateAffinity();
			break;
		default:
			break;

		}
		
	}
	private void calculateAffinity() {
		int result = personMannager.calculateAffinity(personMannager.searchPerson(mainWindow.getcheckselec()[0]), personMannager.searchPerson(mainWindow.getcheckselec()[1]));
		dialogAffinity.setProgressBar(result);
		dialogAffinity.setVisible(true);
		mainWindow.quitCheck();
	}

	private void addPersonDialog() {
		personMannager.addPerson(dialogPerson.getPerson(personMannager.generateId()));
		mainWindow.refreshTableMan(personMannager.getPersonList());
		dialogPerson.cleanForm();
		dialogPerson.setVisible(false);
		fileManager.writeFile(personMannager.getPersonList(), ConstantsUI.PATH);
	}

	public static void main(String[] args) {
		try {
			new Controller();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
